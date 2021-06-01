package cn.supfox.request;

import com.gooben.yxt.service.api.ws.v1.ItfSentResultSmsWs;
import com.gooben.yxt.service.api.ws.v1.ItfTaskSmsListResult;
import lombok.Data;

import javax.xml.bind.annotation.XmlElement;
import java.util.List;

@Data
public class YxtCallbackResultRequest {

    private String content;

    private ItfSentResultSmsWs type;

    protected List<ItfTaskSmsListResult> itfTaskSmsListResults;
}
