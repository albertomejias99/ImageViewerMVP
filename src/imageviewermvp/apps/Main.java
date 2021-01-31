package imageviewermvp.apps;

import imageviewermvp.control.Command;
import imageviewermvp.control.ImagePresenter;
import imageviewermvp.control.NextImageCommand;
import imageviewermvp.control.PrevImageCommand;
import imageviewermvp.model.Image;
import imageviewermvp.view.ImageDisplay;
import java.awt.BorderLayout;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class Main extends JFrame{
    
    private ImageDisplay imageDisplay;
    private ImagePresenter imagePresenter;
    private List<Image> images;
    private Map<String,Command> commands = new HashMap<>();


    public static void main(String[] args) {
        new Main().execute();
    }

    public Main() {
        this.setTitle("Image Viewer");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(800,600);
        this.setLocationRelativeTo(null);
        this.getContentPane().add(createImagePanel());
        this.add(toolbar(),BorderLayout.SOUTH);

    }

    private void execute() {
        this.images = new FileImageLoader(new File("fotos")).load();
        this.imageDisplay.display(images.get(0));
        this.imagePresenter = new ImagePresenter(images,imageDisplay);
        this.commands.put("<",new PrevImageCommand(images,imageDisplay));
        this.commands.put(">",new NextImageCommand(images,imageDisplay));
        this.setVisible(true);
    }

    private JPanel createImagePanel() {
        ImagePanel imagePanel = new ImagePanel();
        this.imageDisplay = imagePanel;
        return imagePanel;

    }
    
    private JMenuBar toolbar() {
        JMenuBar toolbar = new JMenuBar();
        toolbar.add(button("<"));
        toolbar.add(button(">"));
        return toolbar;
    }

    private JButton button(String name) {
        JButton button = new JButton(name);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                commands.get(name).execute();
            }
        });
        return button;
    }
    
}
