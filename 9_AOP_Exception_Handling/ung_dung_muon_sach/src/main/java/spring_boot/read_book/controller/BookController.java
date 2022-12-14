package spring_boot.read_book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spring_boot.read_book.model.Book;
import spring_boot.read_book.model.Borrowing;
import spring_boot.read_book.service.IBaseService;
import spring_boot.read_book.service.IBorrwingService;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    IBorrwingService borrowingService;

    @Autowired
    IBaseService bookService;

    @GetMapping("/list")
    public String displayList(Model model){
        List<Book> bookList = bookService.findAll();
        List<Borrowing> borrowList = borrowingService.findAll();
        model.addAttribute("bookList", bookList);
        model.addAttribute("borrowList", borrowList);
        return "book/list";
    }

    @GetMapping("/create")
    public String viewCreate(Model model) {
        Book book = new Book();
        model.addAttribute("book", book);
        return "book/create";
    }

    @PostMapping("/create")
    public String create(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) {
        book.setStatus(book.getQuantity() > 0);
        bookService.add(book);
        redirectAttributes.addFlashAttribute("mess", "Thêm mới thành công");
        return "redirect:/book/list";
    }

    @RequestMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id, RedirectAttributes redirectAttributes) {
        bookService.delete(id);
        redirectAttributes.addFlashAttribute("mess", "Xoá thành công");
        return "redirect:/book/list";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id") String id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "book/edit";
    }

    @PostMapping("/edit")
    public String edit(@ModelAttribute("book") Book book, RedirectAttributes redirectAttributes) {
        bookService.update(book);
        redirectAttributes.addFlashAttribute("mess", "Edit thành công");
        return "redirect:/book/list";
    }

    @RequestMapping("/view/{id}")
    public String view(@PathVariable("id") String id, Model model) {
        Book book = bookService.findById(id);
        model.addAttribute("book", book);
        return "book/view";
    }
}
