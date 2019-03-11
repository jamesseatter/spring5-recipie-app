package eu.seatter.spring5recipeapp.services;

import org.springframework.web.multipart.MultipartFile;

/**
 * Created by IntelliJ IDEA.
 * User: jas
 * Date: 21/01/2019
 * Time: 16:09
 */
public interface ImageService {

    void saveImageFile(Long recipeId, MultipartFile file);
}
