import com.wlqk.cn.GunsApplication;
import com.wlqk.cn.modal.EmailModel;
import com.wlqk.cn.utils.MailSendUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = GunsApplication.class)
@WebAppConfiguration
public class SocketQqTest {

    @Autowired
    private MailSendUtils mailSendUtils;

    /**
     * Java Mail 文本发送
     **/
    @Test
    public void EmaiTest() {
        for (int i = 0; i < 2; i++) {
            EmailModel emailModel = new EmailModel();
            emailModel.setEmailTheme("异国他乡"+i);
            emailModel.setRecieverName("wang.bo"+i);
            emailModel.setEmailContent("愿君安好,以慰我心。"+i);
            emailModel.setRecieverEmailAddress("1251605757@qq.com");
            mailSendUtils.sendEmailAsText(emailModel);
        }
    }


}
