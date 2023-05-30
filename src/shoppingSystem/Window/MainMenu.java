package shoppingSystem.Window;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ImageIcon;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import shoppingSystem.ApplicationContext;
import shoppingSystem.CustomerList;
import shoppingSystem.DefaultOrderManagementService;
import shoppingSystem.Order;
import shoppingSystem.OrderManagementService;
import shoppingSystem.Product;
import shoppingSystem.ProductCatalog;
import shoppingSystem.User;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.ScrollPaneConstants;

public class MainMenu extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel InfoLabel;
	private JPanel panel;
	private ApplicationContext context;
	private JTable tableCatalog;
	private JTable tableCustomers;
	private JTable tableOrders;
	private JScrollPane scrollPaneOrders;
	private JScrollPane scrollPaneCatalog;
	private JScrollPane scrollPaneCustomer;
	private JButton buttonEmail;
	private JButton btnChangePassword;
	private ProductCatalog catalog;
	private JButton CheckoutButton;
	private JPanel panelCheckout;
	private JButton btnNewButton;
	private JPanel panelOrders;
	private JPanel panelCustomer;
	private JPanel panelSettings;
	
	public MainMenu() throws SQLException, Exception {
		context = ApplicationContext.getInstance();
		setIconImage(new ImageIcon(System.getProperty("user.dir")+"\\src\\shoppingSystem\\icon\\STL211940.jpg").getImage());
//		if (context.getLoggedInUser() != null) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 739, 724);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList<Object> menuList = new JList<Object>();
			menuList.addListSelectionListener(new ListSelectionListener() {
				  public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting()) {
					
					switch ((String) menuList.getSelectedValue()) {
					case "Sign Out": {
						setAllToinVisible();
						context.setLoggedInUser(null);
						new SignInMenu();
						dispose();
						break;
					}
					
					case "Sign Out and Close": {
						context.setLoggedInUser(null);
						new SignInMenu();
						System.exit(0);
						break;
					}
					
					case "Product Catalog": {
						setAllToinVisible();
						
						
						
						InfoLabel.setText("Product Catalog");
						if (context.getSessionCart() != null  && !context.getSessionCart().isEmpty()) {
							CheckoutButton.setVisible(true);
						}
						panelCheckout.setVisible(true);
						break;
					}
					case "My Orders": {
						setAllToinVisible();
						InfoLabel.setText("My Orders");
						panelOrders.setVisible(true);
						break;
					}
					case "Settings": {
						setAllToinVisible();

						InfoLabel.setText("Settings");
						panelSettings.setVisible(true);
						break;
						
					}
					case "Customers list": {
						setAllToinVisible();
						InfoLabel.setText("Customers");
						panelCustomer.setVisible(true);
						break;
							
							
						}
					}
						
					
					
				}
			}
		});
		menuList.setFont(new Font("Arial", Font.PLAIN, 16));
		menuList.setModel(new AbstractListModel<Object>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			String[] values = new String[] {"Product Catalog", "My Orders", "Settings", "Customers list", "Sign Out" ,"Sign Out and Close"};
			public int getSize() {
				return values.length;
			}
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		menuList.setBounds(10, 11, 139, 663);
		contentPane.add(menuList);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(159, 11, 554, 663);
		contentPane.add(scrollPane);
		
		panel = new JPanel();
		scrollPane.setViewportView(panel);
		panel.setLayout(null);
		panelOrders = new JPanel();
		panelOrders.setBounds(111, 59, 366, 535);
		panel.add(panelOrders);
		panelCustomer = new JPanel();
		panelCustomer.setBounds(111, 59, 366, 535);
		panel.add(panelCustomer);
		panelCustomer.setLayout(null);
		panelSettings = new JPanel();
		panelSettings.setBounds(55, 112, 487, 538);
		panel.add(panelSettings);
		panelSettings.setLayout(null);
		
		
		
		InfoLabel = new JLabel("Welcome back :" + context.getLoggedInUser().getFirstName()+ " " + context.getLoggedInUser().getLastName()+ " (U W U)//");
		InfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		InfoLabel.setFont(new Font("Arial", Font.PLAIN, 16));
		InfoLabel.setBounds(101, 11, 387, 50);
		panel.add(InfoLabel);
		
		panelCheckout = new JPanel();
		panelCheckout.setBounds(36, 59, 506, 591);
		panel.add(panelCheckout);
		panelCheckout.setLayout(null);
		
		 CheckoutButton = new JButton("Checkout");
		 CheckoutButton.setBounds(356, 541, 140, 39);
		 panelCheckout.add(CheckoutButton);
		 CheckoutButton.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		if (context.getSessionCart() != null || context.getSessionCart().isEmpty()) {
		 			new CheckoutMenu();
		 			dispose();
		 			
		 		}
		 		
		 	}
		 	
		 });
		 
		 CheckoutButton.setBorderPainted(false);
		 CheckoutButton.setBackground(Color.GREEN);
		 CheckoutButton.setFont(new Font("Arial", Font.BOLD, 16));
	tableCatalog = new JTable();
	tableCatalog.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	tableCatalog.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	
	scrollPaneCatalog = new JScrollPane();
	scrollPaneCatalog.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
	scrollPaneCatalog.setBounds(73, 0, 366, 535);
	scrollPaneCatalog.setViewportView(tableCatalog);
	panelCheckout.add(scrollPaneCatalog);
	
	tableCatalog.setModel(new DefaultTableModel(new Object[][] {},new String[] {"Id", "Product Name", "Price"}) {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		boolean[] columnEditables = new boolean[] {
			false, true, true
		};
		public boolean isCellEditable(int row, int column) {
			return columnEditables[column];
		}
	});
	tableCatalog.getColumnModel().getColumn(0).setPreferredWidth(33);
	tableCatalog.getColumnModel().getColumn(1).setPreferredWidth(283);
	tableCatalog.getColumnModel().getColumn(2).setPreferredWidth(49);
	
	btnNewButton = new JButton("Add to cart");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			int selectedRow = tableCatalog.getSelectedRow();
			String Id = String.valueOf((int) tableCatalog.getValueAt(selectedRow, 0 )); ;
			catalog.processAddToCart(catalog.fetchProduct(Id));
			CheckoutButton.setVisible(true);
		}
	});
	btnNewButton.setBackground(Color.GREEN);
	btnNewButton.setBorderPainted(false);
	btnNewButton.setFont(new Font("Arial", Font.PLAIN, 16));
	btnNewButton.setActionCommand("");
	btnNewButton.setBounds(10, 545, 168, 34);
	panelCheckout.add(btnNewButton);
	tableOrders = new JTable();
	tableOrders.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	tableOrders.setModel(new DefaultTableModel(new Object[][] {},new String[] {	"Customer id", "Creditcard number","Order ID"}) {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		boolean[] columnEditables = new boolean[] {false, false,false};
		public boolean isCellEditable(int row, int column) {
			return columnEditables[column];
		}
	});
	DefaultTableModel modelCatalog = (DefaultTableModel) tableCatalog.getModel();
		 
		 CheckoutButton.setVisible(false);
	Object[] orderRowData = new Object[3];
	DefaultTableModel modelOrders = (DefaultTableModel) tableOrders.getModel();
	OrderManagementService CurrentorderManagementService = DefaultOrderManagementService.getInstance();
	Order[] loggedInUserOrders = CurrentorderManagementService.getOrdersByUserId(context.getLoggedInUser().getId());
		for ( Order Orders : loggedInUserOrders) {
			orderRowData[0] = Orders.getCustomerId();
			orderRowData[1] = Orders.getCreditcardLast4Number();
			orderRowData[2] = Orders.getOrderId();
			modelOrders.addRow(orderRowData);
		}
		
		
		
		
		
		tableCustomers = new JTable();
		tableCustomers.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableCustomers.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
		scrollPaneCustomer = new JScrollPane();
		scrollPaneCustomer.setBounds(0, 0, 366, 535);
		panelCustomer.add(scrollPaneCustomer);
		scrollPaneCustomer.setViewportView(tableCustomers);
		tableCustomers.setModel(new DefaultTableModel(new Object[][] {},new String[] {"Name", "Last Name", "E-mail"}) 
		{	/** */
			private static final long serialVersionUID = 1L;
			boolean[] columnEditables = new boolean[] {false, false, false};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}});
		DefaultTableModel modelCustomer = (DefaultTableModel) tableCustomers.getModel();
		
		
		
		buttonEmail = new JButton("Change E-mail");
		buttonEmail.setBounds(0, 0, 143, 50);
		panelSettings.add(buttonEmail);
		buttonEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditData("E-mail");
			}
		});
		buttonEmail.setFont(new Font("Arial", Font.PLAIN, 16));
		
		btnChangePassword = new JButton("Change Password");
		btnChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new EditData("Password");
				
			}
		});
		btnChangePassword.setFont(new Font("Arial", Font.PLAIN, 16));
		btnChangePassword.setBounds(250, 0, 188, 50);
		panelSettings.add(btnChangePassword);
	panelOrders.setLayout(null);
	
	
	

	
	scrollPaneOrders = new JScrollPane();
	scrollPaneOrders.setBounds(0, 0, 366, 535);
	panelOrders.add(scrollPaneOrders);
	
	scrollPaneOrders.setViewportView(tableOrders);
	
	
	 
	 
	tableOrders.getColumnModel().getColumn(1).setPreferredWidth(103);
	tableOrders.setAutoResizeMode(JTable.AUTO_RESIZE_NEXT_COLUMN);
	tableOrders.addMouseListener(new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			int index = tableOrders.getSelectedRow();
			new OrderProductsInfo(loggedInUserOrders[index]);
		}
	});
		User[] users = new CustomerList().getUsers();
		Object[] userRowData = new Object[3];
		
		
		for (User newUser : users) {
			userRowData[0] = newUser.getFirstName();
			userRowData[1] = newUser.getLastName();
			userRowData[2] = newUser.getEmail();
			modelCustomer.addRow(userRowData);
		}
		
		
		 catalog = new ProductCatalog();
		Product products[] = catalog.getProducts();
		Object[] rowData11 = new Object[3];
		
		
		for ( Product newProduct : products ) {
			rowData11[0] = newProduct.getId();
			rowData11[1] = newProduct.getProductName();
			rowData11[2] = newProduct.getProductPrice();
			modelCatalog.addRow(rowData11);
		}
		
		
		
		setAllToinVisible();
		setVisible(true);
//	}
//		else {
//			new SignInMenu();
//			dispose();
//		}
	}
	
	private void setAllToinVisible() {
		 panelCheckout.setVisible(false);
		 panelCustomer.setVisible(false);
		 panelOrders.setVisible(false);
		 panelSettings.setVisible(false);
		
	}
}
