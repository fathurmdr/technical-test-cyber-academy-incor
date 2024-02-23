package com.fathu.rahman.inkor.test.controller;

import com.fathu.rahman.inkor.test.entity.Member;
import com.fathu.rahman.inkor.test.model.CreateMemberRequest;
import com.fathu.rahman.inkor.test.model.UpdateMemberRequest;
import com.fathu.rahman.inkor.test.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Controller
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping(path = "/")
    public String showMemberList(Model model){
        List<Member> members = memberService.getList();

            model.addAttribute("members",members);

        return "members";
    }

    @GetMapping(path = "/create")
    public String showCreateMemberForm(){
        return "create_member";
    }

    @PostMapping(path = "/create")
    public String createMember(@Valid @ModelAttribute CreateMemberRequest request, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("errors", result.getAllErrors());
            return "create_member";
        }

        memberService.create(request);

        return "redirect:/";
    }


    @GetMapping(path = "/{id}")
    public String showMemberDetail(@PathVariable("id") Integer id, Model model){
        Optional<Member> member = memberService.getDetail((id));

        if(member.isEmpty()){
            return "redirect:/";
        }

        model.addAttribute("member", member.get());
        return "member_detail";
    }

    @GetMapping(path = "/update/{id}")
    public String showUpdateMemberForm(@PathVariable("id") Integer id, Model model){
        Optional<Member> member = memberService.getDetail((id));

        if(member.isEmpty()){
            return "redirect:/";
        }

        model.addAttribute("member", member.get());
        return "update_member";
    }
    @PostMapping(path = "/update/{id}")
    public String updateMember(@PathVariable("id") Integer id, @Valid UpdateMemberRequest request, BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("errors", result.getAllErrors());
            return "create_member";
        }

        memberService.update(id, request);

        return "redirect:/";
    }

    @PostMapping(path = "/delete/{id}")
    public String deleteMember(@PathVariable("id") Integer id){

        memberService.delete(id);

        return "redirect:/";
    }

}
