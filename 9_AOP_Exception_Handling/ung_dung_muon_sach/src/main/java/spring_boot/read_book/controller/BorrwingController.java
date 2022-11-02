package spring_boot.read_book.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spring_boot.read_book.exveption.BookException;
import spring_boot.read_book.model.Borrowing;
import spring_boot.read_book.service.IBaseService;
import spring_boot.read_book.service.IBorrwingService;

@Controller
@RequestMapping("/borrow")
public class BorrwingController {
    @Autowired
    IBorrwingService borrowingService;

    @Autowired
    IBaseService bookService;

    @GetMapping("/create/{id}")
    public String borrow(RedirectAttributes redirectAttributes, @PathVariable("id") String id) throws BookException {

        if (bookService.findById(id).getQuantity() <= 0) {
            redirectAttributes.addFlashAttribute("mess", "Sách đã hết, không được mượn");
            throw new BookException("Số lượng sách bé hơn 0");
        }

        borrowingService.add(new Borrowing(), id);
        redirectAttributes.addFlashAttribute("mess", "Mượn sách thành công");
        return "redirect:/book/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int idBorrow, RedirectAttributes redirectAttributes) {
        if (!borrowingService.findByIdBorrow(idBorrow).isPresent()) {
            redirectAttributes.addFlashAttribute("mess", "Không tìm thấy mã sách");
            return "redirect:/book/list";
        }

        borrowingService.delete(idBorrow);
        redirectAttributes.addFlashAttribute("mess", "Trả sách thành công");
        return "redirect:/book/list";
    }

    @ExceptionHandler(BookException.class)
    public String errorHandler(BookException e, Model model) {
        model.addAttribute("message", e.getMessage());
        System.out.println("=============Book controller============");
        return "error";
    }
}
