package bms.com.springbasic1.classes;

import org.springframework.stereotype.Component;

@Component
public class Laptop {

    //Class Attributes    
    private Integer length;
    private Integer width;
    private String brandName;

    //Getters and Setters for all attributes
    public Integer getLength() {
        return length;
    }
    public void setLength(Integer length) {
        this.length = length;
    }
    public Integer getWidth() {
        return width;
    }
    public void setWidth(Integer width) {
        this.width = width;
    }
    public String getBrandName() {
        return brandName;
    }
    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    //Constructor Method

    public void Laptop() {
        System.out.println("Laptop Object is Created");
    }

    @Override
    public String toString() {
        return "Laptop [length=" + length + ", width=" + width + ", brandName=" + brandName + "]";
    }  
    
    
}

