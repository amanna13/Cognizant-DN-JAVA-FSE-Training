import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static boolean BinarySearchFunction(Product[] products, String item) {


        int i = 0;
        int j = products.length - 1;

        while( i <= j ) {
            int mid = i + (j - i)/ 2;

            // str1.compareToIgnoreCase(str2)
            // negative --> str1 comes before str2
            // positive --> str1 comes after str2

            int cmp = products[mid].productName.compareToIgnoreCase(item);

            if(cmp == 0) {
                return true;
            } else if (cmp < 0) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }

        return false;
    }

    public static boolean LinearSearchFunction(Product[] products, String item) {

        for (Product product : products) {
            if (product.productName.equals(item)) {
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {

        Product p1 = new Product(3131, "Shampoo", "Wellness");
        Product p2 = new Product(3595, "Bread", "Food");
        Product p3 = new Product(9352, "Mobile Phone", "Electronics");
        Product p4 = new Product(4949, "Apple", "Food");
        Product p5 = new Product(2019, "Cauliflower", "Vegetable");
        Product p6 = new Product(5759, "Milk", "Dairy");
        Product p7 = new Product(8494, "Books", "Books");

        Product[] products = {p1, p2, p3, p4, p5, p6, p7};

        // The array is not sorted, hence we are sorting it
        Arrays.sort(products, Comparator.comparing(product -> product.productName));

        System.out.println(BinarySearchFunction(products , "Milk"));

        System.out.println(LinearSearchFunction(products, "Milk"));

    }
}