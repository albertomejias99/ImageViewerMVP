package imageviewermvp.view;

import imageviewermvp.model.Image;
import java.util.List;

public interface ImageLoader {
    List<Image> load();
}