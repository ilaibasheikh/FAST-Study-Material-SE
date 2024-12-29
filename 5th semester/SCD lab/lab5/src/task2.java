import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class task2 extends JFrame {
    private JTabbedPane tabbedPane;
    private JPanel mainPanel;
    private JTable productTable;
    private JTextField productInputField;
    private JSpinner productQuantitySpinner;
    private JButton addToCartBtn;
    private JTable cartTable;
    private JTextField removeProductField;
    private JButton removeProductBtn;
    private JTextField updateProductField;
    private JSpinner updateQuantitySpinner;
    private JButton updateProductBtn;
    private JButton calculateTotalBtn;
    private JTextField totalAmountField;

    private HashMap<String, Integer> shoppingCart = new HashMap<>();
    private HashMap<String, Double> productPriceList = new HashMap<>();

    public task2() {
        setContentPane(mainPanel);
        setTitle("Shopping Cart System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        productPriceList.put("Milk", 10.0);
        productPriceList.put("Bread", 20.0);
        productPriceList.put("Eggs", 15.0);

        populateProductTable();

        addToCartBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addProductToCart();
            }
        });

        removeProductBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeProductFromCart();
            }
        });

        updateProductBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCartProduct();
            }
        });

        calculateTotalBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTotalAmount();
            }
        });
    }

    private void populateProductTable() {
        String[] columnNames = {"Product Name", "Price"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (String product : productPriceList.keySet()) {
            model.addRow(new Object[]{product, productPriceList.get(product)});
        }

        productTable.setModel(model);
    }

    private void addProductToCart() {
        String productName = productInputField.getText().trim();
        int quantity = (Integer) productQuantitySpinner.getValue();

        if (productPriceList.containsKey(productName)) {
            shoppingCart.put(productName, shoppingCart.getOrDefault(productName, 0) + quantity);
            refreshCartTable();
        } else {
            JOptionPane.showMessageDialog(mainPanel, "Product not found.");
        }
    }

    private void removeProductFromCart() {
        String productName = removeProductField.getText().trim();
        if (shoppingCart.containsKey(productName)) {
            shoppingCart.remove(productName);
            refreshCartTable();
        } else {
            JOptionPane.showMessageDialog(mainPanel, "Product not in cart.");
        }
    }

    private void updateCartProduct() {
        String productName = updateProductField.getText().trim();
        int newQuantity = (Integer) updateQuantitySpinner.getValue();

        if (shoppingCart.containsKey(productName)) {
            if (newQuantity > 0) {
                shoppingCart.put(productName, newQuantity);
            } else {
                shoppingCart.remove(productName);
            }
            refreshCartTable();
        } else {
            JOptionPane.showMessageDialog(mainPanel, "Product not in cart.");
        }
    }

    private void calculateTotalAmount() {
        double total = 0.0;
        for (String product : shoppingCart.keySet()) {
            total += productPriceList.get(product) * shoppingCart.get(product);
        }
        totalAmountField.setText(String.format("%.2f", total));
    }

    private void refreshCartTable() {
        String[] columnNames = {"Product Name", "Quantity", "Total Price"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (String product : shoppingCart.keySet()) {
            int quantity = shoppingCart.get(product);
            double price = productPriceList.get(product);
            double totalPrice = price * quantity;
            model.addRow(new Object[]{product, quantity, String.format("%.2f", totalPrice)});
        }

        cartTable.setModel(model);
    }

    public static void main(String[] args) {
        new task2();
    }
}
