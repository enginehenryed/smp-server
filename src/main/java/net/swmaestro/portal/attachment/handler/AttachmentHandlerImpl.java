package net.swmaestro.portal.attachment.handler;

import net.swmaestro.portal.attachment.dao.AttachmentDAO;
import net.swmaestro.portal.attachment.vo.Attachment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by junha on 2016. 11. 20..
 */

@Service("attachmentHandler")
public class AttachmentHandlerImpl implements AttachmentHandler {

    @Resource(name="attachmentDAO")
    private AttachmentDAO attachmentDAO;

    @Override
    public Attachment getAttachment(String attachmentId) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("attachmentId", attachmentId);
        return attachmentDAO.selectAttachment(map);
    }
}
