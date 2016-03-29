package br.edu.ifpb.bean;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
 
@ManagedBean
public class ImagemBEAN {
     
    private List<String> imagens;
     
    @PostConstruct
    public void init() {
        imagens = new ArrayList<String>();
        for (int i = 1; i <= 12; i++) {
            imagens.add("transport" + i + ".png");
        }
    }
 
    public List<String> getImages() {
        return imagens;
    }
}