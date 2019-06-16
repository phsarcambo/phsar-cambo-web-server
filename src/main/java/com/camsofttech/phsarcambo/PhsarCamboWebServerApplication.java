package com.camsofttech.phsarcambo;

import com.camsofttech.phsarcambo.model.*;
import com.camsofttech.phsarcambo.service.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class PhsarCamboWebServerApplication implements CommandLineRunner {


    private static Logger logger = LogManager.getLogger(PhsarCamboWebServerApplication.class);


    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ProductService productService;
    @Autowired
    private OrderService orderService;

    public static void main(String[] args) {
        SpringApplication.run(PhsarCamboWebServerApplication.class, args);
        System.setProperty("logFilename", "CHIVONLOG");

        logger.info("Hello world");


    }

    @Override
    public void run(String... args) throws Exception {

        onInitRole();

        onInitUser();

        //onInitCategory();

        //onInitProduct();
    }


    private void onInitRole() {
        if (roleService.findByRoleName("ADMIN_ROLE") == null) {
            Role roleAdmin = new Role();
            roleAdmin.setRoleName("ADMIN_ROLE");
            roleAdmin.setDescription("Admin Role");
            roleAdmin.setStatus(EStatus.ACTIVE);
            roleService.onSave(roleAdmin);
        }
        if (roleService.findByRoleName("USER_ROLE") == null) {
            Role roleUser = new Role();
            roleUser.setRoleName("USER_ROLE");
            roleUser.setDescription("User Role");
            roleUser.setStatus(EStatus.ACTIVE);
            roleService.onSave(roleUser);
        }
    }


    private void onInitUser() {
        //userService.onDelete(19L);
        //userService.onDelete(20L);

        Role adminRole = roleService.findByRoleName("ADMIN_ROLE");
        Role userRole = roleService.findByRoleName("USER_ROLE");
        if (userService.findByUsername("admin") == null) {
            User userAdmin = new User();
            userAdmin.setFirstName("Admin");
            userAdmin.setLastName("Admin");
            userAdmin.setEmail("admin@gmail.com");
            userAdmin.setUsername("admin");
            userAdmin.setPassword("123456");
            userAdmin.setRoles(Arrays.asList(adminRole));
            userAdmin.setStatus(EStatus.ACTIVE);
            userService.onSave(userAdmin);
        }
        if (userService.findByUsername("user") == null) {
            User userUser = new User();
            userUser.setFirstName("User");
            userUser.setLastName("User");
            userUser.setEmail("user@gmail.com");
            userUser.setUsername("user");
            userUser.setPassword("123456");
            userUser.setRoles(Arrays.asList(userRole));
            userUser.setStatus(EStatus.ACTIVE);
            userService.onSave(userUser);
        }
    }


    private void onInitCategory() {
        Category category;
        Category categoryParent;
        for (int i = 0; i < 10; i++) {
            category = new Category();
            categoryParent = categoryService.findById(Long.valueOf(i));
            if(categoryParent != null){
                category.setParent(categoryParent);
            }else{
                category.setParent(null);
            }
            category.setNameEn("Category "+i);
            category.setNameKh("Category "+i);
            category.setDescEn("Category "+1);
            category.setDescKh("Category "+1);
            categoryService.onSave(category);
        }
    }

    private void onInitProduct() {

        List<Category> categories  = categoryService.getCategories();
        if(categories.size() > 0){
            for (Category category : categories){
                Product product;
                for (int i = 0 ; i < 10 ; i++){
                    product = new Product();
                    if(productService.findById(Long.valueOf(i)) ==  null){
                        product.setNameEn("Product "+i);
                        product.setNameKh("Product "+i);
                        product.setDescEn("Product "+i);
                        product.setDescKh("Product "+i);
                        product.setCategory(category);
                        productService.onSave(product);
                    }
                }
            }
        }
    }


    private void onInitOrder(){

    }
}
