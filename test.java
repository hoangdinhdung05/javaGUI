import javax.swing.UIManager;

import view.MouseExampleView;

class test {
    public static void main(String[] args) {
        try {
            
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            new MouseExampleView();

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}