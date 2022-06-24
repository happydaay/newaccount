package newaccount.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import newaccount.PreapplyApplication;
import newaccount.domain.PreAppliedE;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "PreApplicationA_table")
@Data
public class PreApplicationA {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String appliedStatus;

    private String custNo;

    @PostPersist
    public void onPostPersist() {
        PreAppliedE preAppliedE = new PreAppliedE();
        BeanUtils.copyProperties(this, preAppliedE);
        preAppliedE.publishAfterCommit();
    }

    public static PreApplicationARepository repository() {
        PreApplicationARepository preApplicationARepository = PreapplyApplication.applicationContext.getBean(
            PreApplicationARepository.class
        );
        return preApplicationARepository;
    }

    public static void statusUpdateP(IncomeVerifiedE incomeVerifiedE) {
        PreApplicationA preApplicationA = new PreApplicationA();
        /*
        LOGIC GOES HERE
        */
        // repository().save(preApplicationA);

    }

    public static void statusUpdateP(AccountOpenedE accountOpenedE) {
        PreApplicationA preApplicationA = new PreApplicationA();
        /*
        LOGIC GOES HERE
        */
        // repository().save(preApplicationA);

    }

    public static void statusUpdateP(PreAppliedE preAppliedE) {
        PreApplicationA preApplicationA = new PreApplicationA();
        /*
        LOGIC GOES HERE
        */
        // repository().save(preApplicationA);

    }
    // keep

}
