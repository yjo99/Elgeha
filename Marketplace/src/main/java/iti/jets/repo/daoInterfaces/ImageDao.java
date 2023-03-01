package iti.jets.repo.daoInterfaces;

import java.util.List;

import iti.jets.entities.Image;

public interface ImageDao {
	public void save(Image image);
    public void deleteById(int id);
    public void update(Image image);
    public Image selectImage(int id);
    public List<Image> selectImages();
}
