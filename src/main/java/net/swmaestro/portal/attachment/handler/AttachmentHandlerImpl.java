package net.swmaestro.portal.attachment.handler;

import net.swmaestro.portal.attachment.dao.AttachmentDAO;
import net.swmaestro.portal.attachment.vo.Attachment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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

    @Override
    public int removeArticleAttachments(long articleId) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("articleId", articleId);

        return attachmentDAO.removeArticleAttachments(map);
    }

    @Override
    public int insertArticleAttachments(long articleId, List<String> attachmentIds) throws Exception {
        List<Map<String, Object>> mapsList = new ArrayList<>();

        for (String attachmentId : attachmentIds) {
            Map<String, Object> map = new HashMap<>();
            map.put("articleId", articleId);
            map.put("attachmentId", attachmentId);
            mapsList.add(map);
        }

        return attachmentDAO.insertArticleAttachments(mapsList);
    }
}
