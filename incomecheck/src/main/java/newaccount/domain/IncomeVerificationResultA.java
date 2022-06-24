package newaccount.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import newaccount.IncomecheckApplication;
import newaccount.domain.IncomeVerifiedE;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "IncomeVerificationResultA_table")
@Data
public class IncomeVerificationResultA {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String custNo;

    private String verifyResult;

    private Long incomeAmount;

    private String appliedStatus;

    @PostPersist
    public void onPostPersist() {
        IncomeVerifiedE incomeVerifiedE = new IncomeVerifiedE();
        BeanUtils.copyProperties(this, incomeVerifiedE);
        incomeVerifiedE.publishAfterCommit();
    }

    public static IncomeVerificationResultARepository repository() {
        IncomeVerificationResultARepository incomeVerificationResultARepository = IncomecheckApplication.applicationContext.getBean(
            IncomeVerificationResultARepository.class
        );
        return incomeVerificationResultARepository;
    }

    public static void incomeVerify(PreAppliedE preAppliedE) {
        IncomeVerificationResultA incomeVerificationResultA = new IncomeVerificationResultA();
        /*
        LOGIC GOES HERE
        */
        // repository().save(incomeVerificationResultA);

        // IncomeVerifiedE incomeVerifiedE = new IncomeVerifiedE();
        /*
        Input Event Content
        */
        // incomeVerifiedE.publishAfterCommit();

    }
    // keep

}
