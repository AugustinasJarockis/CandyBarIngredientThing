package candyBar.usecases;

import candyBar.entities.SourceContract;
import candyBar.persistence.SourceContractsDAO;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;

@ViewScoped
@Named
@Getter
@Setter
public class SourceContractDetails implements Serializable {
    private SourceContract sourceContract;
    @Inject
    private SourceContractsDAO sourceContractsDAO;
    @PostConstruct
    private void init() {
        System.out.println("SourceContractDetails INIT CALLED");
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        Integer sourceContractId = Integer.parseInt(requestParameters.get("contractId"));
        this.sourceContract = sourceContractsDAO.findOne(sourceContractId);
    }
}