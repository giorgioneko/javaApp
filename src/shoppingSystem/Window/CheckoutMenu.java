package shoppingSystem.Window;
 import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import shoppingSystem.ApplicationContext;
import shoppingSystem.Cart;
import shoppingSystem.DefaultOrder;
import shoppingSystem.DefaultOrderManagementService;
import shoppingSystem.Order;
import shoppingSystem.OrderManagementService;
import shoppingSystem.Product;
import shoppingSystem.ProductCatalog;

import javax.swing.JTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ScrollPaneConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
public class CheckoutMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ApplicationContext context;
	private OrderManagementService orderManagementService;
	private JTable checkoutTable;
	private JTextField CreditcardNumbertextField;
	private JLabel errorlabel;
	private ProductCatalog delete;
	private JLabel totalPricelabel;
	private double totalPrice;
	private JButton btnCloseAndEmpty;
	
	{
		context = ApplicationContext.getInstance();
		orderManagementService = DefaultOrderManagementService.getInstance();
	}
	
	public CheckoutMenu(){
		getContentPane().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton()== 4) {
					btnCloseAndEmpty.doClick();		
				}
			}
		});
		setIconImage(new ImageIcon(System.getProperty("user.dir")+"\\src\\shoppingSystem\\icon\\STL211940.jpg").getImage());
	
		delete = new ProductCatalog();
		JLabel header = new JLabel("Checkout");
		setBounds(100, 100, 739, 724);
		header.setHorizontalAlignment(SwingConstants.CENTER);
		header.setFont(new Font("Arial", Font.PLAIN, 16));
		header.setBounds(186, 11, 362, 70);
		getContentPane().add(header);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(196, 92, 369, 295);
		getContentPane().add(scrollPane);
		
		checkoutTable = new JTable();
		checkoutTable.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		checkoutTable.setModel(new DefaultTableModel(new Object[][] {},	new String[] {"total", "Product name", "Price", "id"}) {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {false, false, false, false};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		checkoutTable.getColumnModel().getColumn(0).setPreferredWidth(50);
		checkoutTable.getColumnModel().getColumn(1).setPreferredWidth(267);
		checkoutTable.getColumnModel().getColumn(2).setPreferredWidth(50);
		checkoutTable.getColumnModel().getColumn(3).setPreferredWidth(40);
		scrollPane.setViewportView(checkoutTable);
		Cart currentCart = context.getSessionCart();
		List<Product>products = new ArrayList<> (currentCart.getProducts());
		totalPrice = 0;
		DecimalFormat decimal = new DecimalFormat("0.00");
		
		DefaultTableModel modelCatalog = (DefaultTableModel) checkoutTable.getModel();
		Object[] rowData1 = new Object[4];
		int productLength = products.size();
		for (int i = 0; i <= productLength -1; i++) {
			
			int totalSameProductInCart = currentCart.getHowManySameProducts(products.get(i),products);
			productLength = (productLength - totalSameProductInCart) + 1;
			totalPrice = totalPrice + products.get(i).getProductPrice()* totalSameProductInCart;
			rowData1[0] = totalSameProductInCart;
			rowData1[1] = products.get(i).getProductName();
			rowData1[2] = decimal.format(products.get(i).getProductPrice() * totalSameProductInCart);
			rowData1[3] = products.get(i).getId();
			modelCatalog.addRow(rowData1);
		}
		TableColumnModel columnModel = checkoutTable.getColumnModel();
		TableColumn coli = columnModel.getColumn(3);
		columnModel.removeColumn(coli);
		
		String prioeFormated = decimal.format(totalPrice);
		totalPricelabel = new JLabel("Total price : ¥ " + prioeFormated);
		totalPricelabel.setFont(new Font("Arial Black", Font.PLAIN, 16));
		totalPricelabel.setBounds(186, 398, 362, 35);
		getContentPane().add(totalPricelabel);
		
		JLabel CreditcardnumberLabel = new JLabel("Creditcard number");
		CreditcardnumberLabel.setFont(new Font("Arial", Font.BOLD, 11));
		CreditcardnumberLabel.setBounds(62, 438, 130, 35);
		getContentPane().add(CreditcardnumberLabel);
		
		CreditcardNumbertextField = new JTextField();
		CreditcardNumbertextField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char nummber  = e.getKeyChar();
				if (!Character.isDigit(nummber)) {
					e.consume();
				}
			}
		});
		CreditcardNumbertextField.setBounds(186, 444, 369, 28);
		getContentPane().add(CreditcardNumbertextField);
		CreditcardNumbertextField.setColumns(10);
		
		JButton confirmButton = new JButton("Confirm");
		confirmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!createOrder(CreditcardNumbertextField.getText())) {
					errorlabel.setVisible(true);
					
					
				}
				else {
				context.getSessionCart().clear();
				dispose();
				try {
					new MainMenu();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			}
		});
		confirmButton.setFont(new Font("Arial", Font.PLAIN, 14));
		confirmButton.setBounds(502, 507, 130, 35);
		getContentPane().add(confirmButton);
		
		 errorlabel = new JLabel("Invalid creditcard number");
		 errorlabel.setForeground(Color.RED);
		 errorlabel.setBounds(186, 478, 369, 18);
		 errorlabel.setVisible(false);
		getContentPane().add(errorlabel);
		
		
		btnCloseAndEmpty = new JButton("Close and empty cart");
		btnCloseAndEmpty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!currentCart.isEmpty()) {
				
					currentCart.clear();
				}
				dispose();
				try {
					new MainMenu();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnCloseAndEmpty.setBorderPainted(false);
		btnCloseAndEmpty.setBackground(Color.RED);
		btnCloseAndEmpty.setActionCommand("Close and empty cart");
		btnCloseAndEmpty.setFont(new Font("Arial", Font.BOLD, 14));
		btnCloseAndEmpty.setBounds(178, 507, 207, 35);
		getContentPane().add(btnCloseAndEmpty);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = checkoutTable.getSelectedRow();
				if (row != -1) {
					TableModel model = checkoutTable.getModel();
					String value = String.valueOf((int) model.getValueAt(row, 3));
					Product product = delete.fetchProduct(value);
					context.getSessionCart().deleteProduct(product);
					List<Product>productsDelete = new ArrayList<> (currentCart.getProducts());
					int Amount = context.getSessionCart().getHowManySameProducts(product, productsDelete);
					totalPrice = totalPrice - product.getProductPrice();
					String prioeFormated = decimal.format(totalPrice);
					totalPricelabel.setText("Total price : ¥ " + prioeFormated);
					
					if (Amount == 0) {
					modelCatalog.removeRow(row);
					
					}
					
					else {
					
					modelCatalog.setValueAt(Amount, row, 0);
					modelCatalog.setValueAt(decimal.format(product.getProductPrice() * Amount), row, 2 );
					}
					if (context.getSessionCart().isEmpty()) {
						btnCloseAndEmpty.setText("Close");
						confirmButton.setVisible(false);
						totalPricelabel.setText("Total price : ¥ " + decimal.format(0.00));
						
					}	
				}
			}
		});
		btnDelete.setFont(new Font("Arial", Font.BOLD, 14));
		btnDelete.setBorderPainted(false);
		btnDelete.setBackground(Color.RED);
		btnDelete.setActionCommand("Close and empty cart");
		btnDelete.setBounds(95, 92, 91, 35);
		getContentPane().add(btnDelete);
		this.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent windowEvent) {
				try {
					new MainMenu();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		setVisible(true);	
	}
	
	
	
	private boolean createOrder(String creditCardNumber) {
		Order order = new DefaultOrder();
		if (!order.isCreditCardNumberValid(creditCardNumber)) {
			return false;
		}
		
		order.setCreditCardNumber(creditCardNumber);
		order.setProducts(context.getSessionCart().getProducts());
		order.setCustomerId(context.getLoggedInUser().getId());
		orderManagementService.addOrder(order);
		return true;
	}
}
