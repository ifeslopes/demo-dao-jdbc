package aplication;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;


public class Program {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        SellerDao sellerDao = DaoFactory.createSellerDao();
        Seller seller = sellerDao.findById(2);

        System.out.println("==== TEST 1: seller findById =====");
        System.out.println(seller);

        System.out.println("\n==== TEST 2: seller findByDepartmentd =====");
        Department department = new Department(2,null);
        List<Seller> list = sellerDao.findByDepartment(department);

        for (Seller obj: list){
            System.out.println(obj);
        }

        System.out.println("\n==== TEST 3: seller findAll =====");

         list = sellerDao.findAll();

        for (Seller obj: list){
            System.out.println(obj);
        }

        System.out.println("\n==== TEST 4: seller findAll =====");
        Seller NewSeller = new Seller(null, "LALA", "lala@gmail.com", new Date(), 4000.00,department);
        sellerDao.insert(NewSeller);
        System.out.println("Inserted! New id = "+ NewSeller.getId());


        System.out.println("\n==== TEST 5: seller update =====");
        seller = sellerDao.findById(2);
        seller.setName("Martha Waine");
        sellerDao.update(seller);
        System.out.println("Update completed");

        System.out.println("\n==== TEST 5: seller update =====");
        System.out.println("Enter id for delete test: ");
        int  id =sc.nextInt();
        sellerDao.deleteById(id);
        System.out.println("Delete completed: ");
        sc.close();
    }
}
