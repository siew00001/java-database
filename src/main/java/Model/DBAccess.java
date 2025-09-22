package Model;

import org.jooq.DSLContext;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import static com.example.jooq.codegen.tables.Products.*;

public class DBAccess {
    private DSLContext context;

    public DBAccess() {
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/Einkaufsliste.db");
            context = DSL.using(connection, SQLDialect.SQLITE);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Result<Record> getAllProductsFromDB() {
        if (context == null) {
            throw new IllegalStateException("Database connection not initialized.");
        }
        return context.select().from(PRODUCTS).fetch();
    }

    private List<Product> resultToProductList(Result<Record> result) {
        LinkedList<Product> products = new LinkedList<>();
        for (Record record : result) {
            Product product = new Product(record.get(PRODUCTS.ID), record.get(PRODUCTS.NAME), record.get(PRODUCTS.PRICE));
            products.add(product);
        }
        return products;
    }

    public List<Product> getAllProducts() {
        return resultToProductList(getAllProductsFromDB());
    }

    public void addProductToDB(Product product){
        context.insertInto(PRODUCTS).columns(PRODUCTS.NAME, PRODUCTS.PRICE).values(product.getName(), product.getPrice()).execute();
    }
}
