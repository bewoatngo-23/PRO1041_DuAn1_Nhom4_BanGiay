/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domainModel;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;




/**
 *
 * @author admin
 */
 @Entity
 @Table(name = "DeGiay")
 @Getter
 @Setter
 @ToString
public class DeGiay implements Serializable{
   @Id
   @GenericGenerator(name = "generator", strategy = "guid", parameters = {})
   @GeneratedValue(generator = "generator")
   @Column(name = "Id", nullable = true)
   private String id;
   
   @Column(name = "Ma", length = 20, nullable = false)
   private String ma;
   
   @Column(name = "Ten", length = 30, nullable = false)
   private String ten;

    public DeGiay() {
    }

    public DeGiay(String id, String ma, String ten) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
    }
   
   
}
