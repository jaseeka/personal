package com.personal.controller;

import com.common.common.Page;
import com.common.controller.BaseController;
import com.common.utils.DateUtils;
import com.common.utils.JsonUtils;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import com.personal.common.ResultCode;
import com.personal.common.ResultEntity;
import com.personal.common.TypeEnum;
import com.personal.entity.Item;
import com.personal.entity.Note;
import com.personal.entity.User;
import com.personal.service.INoteService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by jaseeka
 * Date 2016/1/21
 * Time 16:00
 */
@RestController
@RequestMapping("/user")
public class NoteController extends BaseController {

    @Resource
    private INoteService noteService;

    /**
     * 获取笔记列表
     * @param session
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "getNoteList", produces = "application/json;charset=UTF-8")
    public String getNoteList(
            HttpSession session,
            HttpServletRequest request,
            HttpServletResponse response
    ){
        ResultEntity resultEntity = new ResultEntity();

        User user = getUser(session);

        Note note = new Note();
        note.setIsDeleted(false);
        note.setUserId(user.getId());

        Page page = new Page(1, Integer.MAX_VALUE-1, "id", Page.ORDER_ASC);

        PageList<Note> noteList = noteService.getListAnd(note, page);

        if (noteList != null && noteList.size() > 0){
            resultEntity.getData().put("list", noteList);
            resultEntity.setCode(ResultCode.SUCCESS);
            resultEntity.setMsg(ResultCode.MSUCCESS);
        }else {
            resultEntity.setCode(ResultCode.FAILURE);
            resultEntity.setMsg(ResultCode.MFAILURE);
        }

        return JsonUtils.Object2Json(resultEntity);
    }

    /**
     * 添加笔记
     * @param content
     * @param time
     * @param session
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "addNote", produces = "application/json;charset=UTF-8")
    public String addNote(
            @RequestParam(value = "content", required = false)String content,
            @RequestParam(value = "time", required = false)String time,
            HttpSession session,
            HttpServletRequest request,
            HttpServletResponse response
    ){
        ResultEntity resultEntity = new ResultEntity();

        User user = getUser(session);

        Note note = new Note();
        note.setContent(content);
        note.setTime(DateUtils.formateStr(time, "dd-MM-yyyy HH:mm"));
        note.setIsDeleted(false);
        note.setUserId(user.getId());

        Boolean result = noteService.add(note) > 0 ? true : false;
        if (result){
            resultEntity.setCode(ResultCode.SUCCESS);
            resultEntity.setMsg(ResultCode.MSUCCESS);
        }else {
            resultEntity.setCode(ResultCode.NO_DATA);
            resultEntity.setMsg(ResultCode.MNO_DATA);
        }

        return JsonUtils.Object2Json(resultEntity);
    }

    /**
     * 删除笔记
     * @param noteId
     * @param session
     * @param request
     * @param response
     * @return
     */
    @RequestMapping(value = "deleteNote", produces = "application/json;charset=UTF-8")
    public String deleteNote(
            @RequestParam(value = "noteId")Integer noteId,
            HttpSession session,
            HttpServletRequest request,
            HttpServletResponse response
    ){
        ResultEntity resultEntity = new ResultEntity();

        Note note = new Note();
        note.setId(noteId);
        note.setIsDeleted(true);

        Boolean result = noteService.update(note);

        if (result){
            resultEntity.setCode(ResultCode.SUCCESS);
            resultEntity.setMsg(ResultCode.MSUCCESS);
        }else {
            resultEntity.setCode(ResultCode.NO_DATA);
            resultEntity.setMsg(ResultCode.MNO_DATA);
        }

        return JsonUtils.Object2Json(resultEntity);
    }
}
