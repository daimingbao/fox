package cn.supfox.pattern.chain.warning;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class WarningSmsHandlerResult {

    private List<String> mobiles =new ArrayList<>();

    private Boolean success;
}
