package newaccount.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import newaccount.AccountopenApplication;
import newaccount.domain.AccountOpenedE;
import org.springframework.beans.BeanUtils;

@Entity
@Table(name = "AccountA_table")
@Data
public class AccountA {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String acctNo;

    private String custNo;

    private String openDate;

    private String accountStatus;

    private String accountBalance;

    @PostPersist
    public void onPostPersist() {
        AccountOpenedE accountOpenedE = new AccountOpenedE();
        BeanUtils.copyProperties(this, accountOpenedE);
        accountOpenedE.publishAfterCommit();
    }

    public static AccountARepository repository() {
        AccountARepository accountARepository = AccountopenApplication.applicationContext.getBean(
            AccountARepository.class
        );
        return accountARepository;
    }
    // keep

}
