import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class ShoppingCartSystem {
    private JTabbedPane tabbedPane1;
    private JPanel panel1;
    private JTable table1;
    private JTextField textField1;
    private JSpinner spinner1;
    private JButton addToCartButton;
    private JTable table2;
    private JTextField textField2;
    private JButton deleteButton;
    private JTextField textField3;
    private JSpinner spinner2;
    private JButton updateButton;
    private JButton calculateAmountButton;
    private JTextField textField4;

    private HashMap<String, Integer> cart = new HashMap<>();
    private HashMap<String, Double> productPrices = new HashMap<>();

    public ShoppingCartSystem() {
        productPrices.put("Milk", 10.0);
        productPrices.put("Bread", 20.0);
        productPrices.put("Eggs", 15.0);

        updateAvailableProductsTable();

        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addToCart();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeFromCart();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateCart();
            }
        });

        calculateAmountButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateTotal();
            }
        });
    }

    private void updateAvailableProductsTable() {
        String[] columnNames = {"Product Name", "Price"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (String product : productPrices.keySet()) {
            model.addRow(new Object[]{product, productPrices.get(product)});
        }

        table1.setModel(model);
    }

    private void addToCart() {
        String productName = textField1.getText().trim();
        int quantity = (Integer) spinner1.getValue();

        if (productPrices.containsKey(productName)) {
            cart.put(productName, cart.getOrDefault(productName, 0) + quantity);
            updateCartTable();
        } else {
            JOptionPane.showMessageDialog(panel1, "Product not found.");
        }
    }

    private void removeFromCart() {
        String productName = textField2.getText().trim();
        if (cart.containsKey(productName)) {
            cart.remove(productName);
            updateCartTable();
        } else {
            JOptionPane.showMessageDialog(panel1, "Product not in cart.");
        }
    }

    private void updateCart() {
        String productName = textField3.getText().trim();
        int newQuantity = (Integer) spinner2.getValue();

        if (cart.containsKey(productName)) {
            if (newQuantity > 0) {
                cart.put(productName, newQuantity);
            } else {
                cart.remove(productName);
            }
            updateCartTable();
        } else {
            JOptionPane.showMessageDialog(panel1, "Product not in cart.");
        }
    }

    private void calculateTotal() {
        double total = 0.0;
        for (String product : cart.keySet()) {
            total += productPrices.get(product) * cart.get(product);
        }
        textField4.setText(String.format("%.2f", total));
    }

    private void updateCartTable() {
        String[] columnNames = {"Product Name", "Quantity", "Total Price"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);

        for (String product : cart.keySet()) {
            int quantity = cart.get(product);
            double price = productPrices.get(product);
            double totalPrice = price * quantity;
            model.addRow(new Object[]{product, quantity, String.format("%.2f", totalPrice)});
        }

        table2.setModel(model);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Shopping Cart System");
        frame.setContentPane(new ShoppingCartSystem().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}