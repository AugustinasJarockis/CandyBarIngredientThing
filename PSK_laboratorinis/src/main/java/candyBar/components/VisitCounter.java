package candyBar.components;

import lombok.Getter;
import lombok.Setter;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@SessionScoped
//@RequestScoped
//@ApplicationScoped
//@ViewScoped
@Getter
@Setter
@Named
public class VisitCounter implements Serializable {
    private int visitCount = 0;
    public void updateVisitCount() {
        visitCount++;
    }
}
