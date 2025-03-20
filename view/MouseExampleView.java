package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import controller.MouseExampleController;
import model.MouseExampleModel;

public class MouseExampleView extends JFrame {
    
    private MouseExampleModel mouseExampleModel;
    private JPanel jPanel_mouse;
	private JLabel jLabel_position;
	private JLabel jLabel_x;
	private JLabel jLabel_y;
	private JLabel jLabel_count;
	private JLabel jLabel_count_value;
	private JLabel jLabel_empty_1;
	private JLabel jLabel_check_in;
	private JLabel jLabel_check_in_value;
	private JLabel jLabel_empty_2;

    public MouseExampleView() {
        this.mouseExampleModel = new MouseExampleModel();
        this.init();
    }

    private void init() {
        this.setTitle("Mouse Example");
        this.setSize(600, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        //Set font
        Font font = new Font("Arial", Font.BOLD, 40);

        //Bắt sự kiện 
        MouseExampleController action = new MouseExampleController(this);
        
        //Viết các Panel trong đây
        jPanel_mouse = new JPanel();
        jPanel_mouse.setBackground(Color.CYAN);
        JPanel jPanel_info = new JPanel();
        jPanel_info.setLayout(new GridLayout(3, 3));
        
        //Gọi sự kiện
        jPanel_mouse.addMouseListener(action);
        jPanel_mouse.addMouseMotionListener(action);

        //Tạo JLabel
        jLabel_position = new JLabel("Position: ");
        jLabel_position.setFont(font);
        jLabel_x = new JLabel("x = ");
        jLabel_x.setFont(font);
        jLabel_y =  new JLabel("y = ");
        jLabel_y.setFont(font);
        jLabel_count = new JLabel("Number of clicks: ");
        jLabel_count.setFont(font);
        jLabel_count_value = new JLabel("n");
        jLabel_count_value.setFont(font);
        jLabel_empty_1 = new JLabel();
        jLabel_empty_1.setFont(font);
        jLabel_check_in = new JLabel("Mouse is in component:");
        jLabel_check_in.setFont(font);
        jLabel_check_in_value = new JLabel("no");
        jLabel_check_in_value.setFont(font);
        jLabel_empty_2 = new JLabel();
        jLabel_empty_2.setFont(font);

        //Thêm các jLabel vào các jPanel
        jPanel_info.add(jLabel_position);
		jPanel_info.add(jLabel_x);
		jPanel_info.add(jLabel_y);
		jPanel_info.add(jLabel_count);
		jPanel_info.add(jLabel_count_value);
		jPanel_info.add(jLabel_empty_1);
		jPanel_info.add(jLabel_check_in);
		jPanel_info.add(jLabel_check_in_value);
		jPanel_info.add(jLabel_empty_2);


        //SetLayout toàn bộ
        this.setLayout(new BorderLayout());
        this.add(jPanel_mouse, BorderLayout.CENTER);
        this.add(jPanel_info, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    //Tạo các phương thức 
    public void click() {
		this.mouseExampleModel.addClick();
		this.jLabel_count_value.setText(this.mouseExampleModel.getCount()+"");
	}
	
	public void enter() {
		this.mouseExampleModel.enter();
		this.jLabel_check_in_value.setText(this.mouseExampleModel.getCheckIn());
	}

	public void exit() {
		this.mouseExampleModel.exit();
		this.jLabel_check_in_value.setText(this.mouseExampleModel.getCheckIn());
	}

	public void update(int x, int y) {
        this.mouseExampleModel.setX(x);
        this.mouseExampleModel.setY(y);
        this.jLabel_x.setText("x = " + this.mouseExampleModel.getX());
        this.jLabel_y.setText("y = " + this.mouseExampleModel.getY());
    }
    

}
