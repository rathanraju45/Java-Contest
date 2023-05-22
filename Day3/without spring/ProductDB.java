import java.sql.*;
import java.util.ArrayList;
import java.util.List;
public class ProductDB {

    Connection conn = null;

    public ProductDB() {
        try {
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/telusko", "postgres", "1234");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void save(Product p) {
        String query = "insert into product (name, type, place, warranty) values(?,?,?,?)";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, p.getName());
            st.setString(2, p.getType());
            st.setString(3, p.getPlace());
            st.setInt(4, p.getWarranty());
            st.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Product> getAll() {
        List<Product> products = new ArrayList<>();
        String query = "select name,type,place,warranty from Product";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setName(rs.getString(1));
                p.setType(rs.getString(2));
                p.setPlace(rs.getString(3));
                p.setWarranty(rs.getInt(4));
                products.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }

    public List<Product> getProductWithName(String sample) {
        String query = "select name,type,place,warranty from Product where name=?";
        List<Product> pwithname = new ArrayList<>();
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, sample);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setName(rs.getString(1));
                p.setType(rs.getString(2));
                p.setPlace(rs.getString(3));
                p.setWarranty(rs.getInt(4));
                pwithname.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pwithname;
    }

    public List<Product> getOutofWarranty() {
        List<Product> products = new ArrayList<>();
        String query = "select name,type,place,warranty from Product where warranty<2023";
        try {
            PreparedStatement st = conn.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setName(rs.getString(1));
                p.setType(rs.getString(2));
                p.setPlace(rs.getString(3));
                p.setWarranty(rs.getInt(4));
                products.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return products;
    }

    public List<Product> getWithString(String sample) {
        String query = "SELECT *\n" +
                "FROM Product\n" +
                "WHERE lower(name) LIKE '%' || ? || '%' OR lower(type) LIKE '%' || ? || '%' OR lower(place) LIKE '%' || ? || '%';\n";
        List<Product> pwithname = new ArrayList<>();
        try {
            PreparedStatement st = conn.prepareStatement(query);
            st.setString(1, sample);
            st.setString(2, sample);
            st.setString(3, sample);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Product p = new Product();
                p.setName(rs.getString(1));
                p.setType(rs.getString(2));
                p.setPlace(rs.getString(3));
                pwithname.add(p);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return pwithname;
    }
}

