package com.bunnies.pinterest.application.controller;

import com.bunnies.pinterest.domain.reply.repository.ReplyRepository;
import com.bunnies.pinterest.domain.reply.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reply")
public class ReplyController {

    @Autowired
    private ReplyService replyService;

    @Autowired
    private ReplyRepository replyRepository;

    /*
    * pin 에 있는 댓글들
    * */



}
