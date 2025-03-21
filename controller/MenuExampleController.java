package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.UIManager;

import view.MenuExampleView;

public class MenuExampleController implements ActionListener {

    private MenuExampleView menuExampleView;

    public MenuExampleController(MenuExampleView menuExampleView) {
        this.menuExampleView = menuExampleView;
    }

    @Override
	public void actionPerformed(ActionEvent e) {
		String button = e.getActionCommand();
		
		if(button.equals("Exit")) {
			System.exit(0);
		}else{
			this.menuExampleView.setTextJLabel("Bạn đã click: "+button);
		}
	}

    public static void main(String[] args) {
        try {
            
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new MenuExampleView();

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
}
