package imageviewermvp.apps;

import imageviewermvp.control.ImagePresenter;
import imageviewermvp.model.Image;
import imageviewermvp.view.ImageDisplay;
import java.awt.PopupMenu;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main extends JFrame{
    private ImageDisplay imageDisplay;
    private ImagePresenter imagePresenter;

    public static void main(String[] args) {
        new Main().execute();
    }

    public Main() {
        this.setTitle("Image Viewer");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        List<Image> list = new ArrayList<>();
        list.add(new Image("fotos/las-canteras-lpavisit_5134531_20190604132257--624x351.jpg"));
        list.add(new Image("fotos/playa_de_las_canteras-gran_canaria_6.jpg"));
        list.add(new Image("fotos/playa-de-Las-Canteras-1024x576.jpg"));
        
        this.getContentPane().add(createImagePanel());

        this.imageDisplay.display(list.get(0));
        this.imagePresenter = new ImagePresenter(list,imageDisplay);
    }

    private void execute() {
        this.setVisible(true);
    }

    private JPanel createImagePanel() {
        ImagePanel imagePanel = new ImagePanel();
        this.imageDisplay = imagePanel;
        return imagePanel;

    }
    
}
