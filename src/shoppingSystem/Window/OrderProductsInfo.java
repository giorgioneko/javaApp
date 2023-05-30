package shoppingSystem.Window;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import shoppingSystem.Order;
import shoppingSystem.Product;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class OrderProductsInfo extends JFrame {

	/**
 * 
 */
private static final long serialVersionUID = 1L;
private JPanel contentPane;
private JTable productTable;
private JLabel totalPriceLabel;
private JLabel orderIdLabel;

/**
 * Launch the application.
 */


/**
 * Create the frame.
 */
public OrderProductsInfo(Order order) {
	setIconImage(new ImageIcon(System.getProperty("user.dir")+"\\src\\shoppingSystem\\icon\\STL211940.jpg").getImage());
	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	setBounds(100, 100, 652, 393);
	contentPane = new JPanel();
	contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

	setContentPane(contentPane);
	contentPane.setLayout(null);
	
	JScrollPane scrollPane = new JScrollPane();
	scrollPane.setBounds(67, 26, 486, 271);
	contentPane.add(scrollPane);
	
	productTable = new JTable();
	productTable.setRowSelectionAllowed(false);
	productTable.setModel(new DefaultTableModel(
		new Object[][] {},new String[] {"Total","Product","Price"}) {
		/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
		boolean[] columnEditables = new boolean[] {false,false,false};
		public boolean isCellEditable(int row, int column) {
			return columnEditables[column];
		}
	});
	productTable.getColumnModel().getColumn(0).setPreferredWidth(33);
	productTable.getColumnModel().getColumn(1).setPreferredWidth(283);
	productTable.getColumnModel().getColumn(2).setPreferredWidth(49);
	scrollPane.setViewportView(productTable);
	
	
	
	double totalPrice = 0;
	DecimalFormat decimal = new DecimalFormat("0.00");
	DefaultTableModel modelCatalog = (DefaultTableModel) productTable.getModel();
	Object[] productRowData = new Object[3];
	List<Product> products = new ArrayList<>(order.getProducts());
	
	int productLength = products.size();
	for (int i = 0; i <= productLength -1; i++) {
		
		int totalProduct =  order.getHowManySameProducts(products.get(i), products);
		totalPrice = totalPrice + products.get(i).getProductPrice()* totalProduct;
		productLength = (productLength - totalProduct) + 1;
		productRowData[0]= totalProduct;
		productRowData[1] = products.get(i).getProductName();
		productRowData[2] = decimal.format(products.get(i).getProductPrice()*totalProduct);
		modelCatalog.addRow(productRowData);
}
	totalPriceLabel = new JLabel("Total price : ¥  " + decimal.format(totalPrice));
	totalPriceLabel.setHorizontalAlignment(SwingConstants.CENTER);
	totalPriceLabel.setBounds(168, 312, 274, 31);
	contentPane.add(totalPriceLabel);
	
	orderIdLabel = new JLabel("Order id :" + order.getOrderId());
	orderIdLabel.setHorizontalAlignment(SwingConstants.CENTER);
		orderIdLabel.setBounds(183, 0, 259, 20);
		contentPane.add(orderIdLabel);
		setVisible(true);
}}
