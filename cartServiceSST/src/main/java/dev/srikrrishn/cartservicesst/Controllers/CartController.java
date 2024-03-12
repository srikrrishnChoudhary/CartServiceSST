package dev.srikrrishn.cartservicesst.Controllers;

import dev.srikrrishn.cartservicesst.Services.FakeStoreCartService;
import dev.srikrrishn.cartservicesst.Services.CartService;
import dev.srikrrishn.cartservicesst.Models.Cart;
import dev.srikrrishn.cartservicesst.Models.Product;




import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
public class CartController {
    private final FakeStoreCartService cartService;

    public CartController(FakeStoreCartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/carts/{id}")
    public Cart getSingleCart(@PathVariable("id") int id) {
        return cartService.getSingleCart(id);
    }

    @GetMapping("/carts")
    public List<Cart> getAllCarts() {
        return cartService.getAllCarts();
    }

    @GetMapping("/carts?startdate={start}&enddate={end}")
    public List<Cart> getInDateRange(@PathVariable("start") String start, @PathVariable("end") String end) {
        LocalDate startDate = LocalDate.parse(start);
        LocalDate endDate = LocalDate.parse(end);
        return cartService.getInDateRange(startDate, endDate);
    }

    @GetMapping("/carts/user/{userId}")
    public List<Cart> getUserCart(@PathVariable("userId") int userId) {
        return cartService.getUserCart(userId);
    }

    @PostMapping("/carts")
    public Cart createCart(@RequestBody Cart cart) {
        return cartService.createCart(cart);
    }

    @PutMapping("/carts/{id}")
    public Cart updateCart(@PathVariable("id") int id, @RequestBody Cart cart) {
        return cartService.updateCart(id, cart);
    }

    @DeleteMapping("/carts/{id}")
    public Cart deleteCart(@PathVariable("id") int id) {
        return cartService.deleteCart(id);
    }

}