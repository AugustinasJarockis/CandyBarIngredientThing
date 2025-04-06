package candyBar.usecases.mybatis;

import candyBar.myBatis.dao.CandybarMapper;
import candyBar.myBatis.model.Candybar;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@Model
public class batis_candyBars {
    @Inject
    private CandybarMapper candyBarMapper;
    @Getter
    private List<Candybar> allCandyBars;

    @Getter @Setter
    private Candybar candyBarToCreate = new Candybar();

    @PostConstruct
    public void init(){
        loadAllCandyBars();
    }
    @Transactional
    public void createCandyBar(){
        this.candyBarMapper.insert(candyBarToCreate);
    }
    private void loadAllCandyBars(){
        this.allCandyBars = candyBarMapper.selectAll();
    }
}
