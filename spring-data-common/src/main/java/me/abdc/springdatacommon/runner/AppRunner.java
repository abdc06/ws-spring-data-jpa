package me.abdc.springdatacommon.runner;

import me.abdc.springdatacommon.entity.Comment;
import me.abdc.springdatacommon.entity.Member;
import me.abdc.springdatacommon.entity.Post;
import me.abdc.springdatacommon.repository.CommentRepository;
import me.abdc.springdatacommon.repository.MemberRepository;
import me.abdc.springdatacommon.repository.PostRepository;
import net.bytebuddy.asm.Advice;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Component
public class AppRunner implements ApplicationRunner {

    List<String> hangles = Arrays.asList("김","이","박","최","정","강","조","윤","장","임","한","오","서","신","권","황","안","송","류","전","홍","고","문","양","손","배","조","백","허","유","남","심","노","정","하","곽","성","차","주","우","구","신","임","나","전","민","유","진","지","엄","채","원","천","방","공","강","현","함","변","염","양","변","여","추","노","도","소","신","석","선","설","마","길","주","연","방","위","표","명","기","반","왕","금","옥","육","인","맹","제","모","장","남","탁","국","여","진","어","은","편","구","용","가","강","건","경","고","관","광","구","규","근","기","길","나","남","노","누","다","단","달","담","대","덕","도","동","두","라","래","로","루","리","마","만","명","무","문","미","민","바","박","백","범","별","병","보","빛","사","산","상","새","서","석","선","설","섭","성","세","소","솔","수","숙","순","숭","슬","승","시","신","아","안","애","엄","여","연","영","예","오","옥","완","요","용","우","원","월","위","유","윤","율","으","은","의","이","익","인","일","잎","자","잔","장","재","전","정","제","조","종","주","준","중","지","진","찬","창","채","천","철","초","춘","충","치","탐","태","택","판","하","한","해","혁","현","형","혜","호","홍","화","환","회","효","훈","휘","희","운","모","배","부","림","봉","혼","황","량","린","을","비","솜","공","면","탁","온","디","항","후","려","균","묵","송","욱","휴","언","령","섬","들","견","추","걸","삼","열","웅","분","변","양","출","타","흥","겸","곤","번","식","란","더","손","술","훔","반","빈","실","직","흠","흔","악","람","뜸","권","복","심","헌","엽","학","개","롱","평","늘","늬","랑","얀","향","울","련");

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @Autowired
    MemberRepository memberRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        for (int i = 0; i < 50; i++) {
            Post post = new Post();
            post.setTitle(randomHangle());
            for (int j = 0; j < 5; j++) {
                Comment comment = new Comment();
                comment.setComment(randomHangle());
                post.addComment(comment);
            }
            postRepository.save(post);
        }

        for (int i = 0; i < 10; i++) {
            memberRepository.save(Member.builder()
                    .memberId(RandomStringUtils.randomAlphanumeric(10))
                    .memberName(randomHangleName())
                    .phone("010" + RandomStringUtils.randomNumeric(8))
                    .createdOn(LocalDateTime.now())
                    .build());
        }
    }

    public String randomHangle() {
        Collections.shuffle(hangles);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < RandomUtils.nextInt(5, 15); i++) {
            sb.append(hangles.get(i));
        }

        return sb.toString();
    }

    public String randomHangleName() {
        Collections.shuffle(hangles);
        return hangles.get(0) + hangles.get(1) + hangles.get(2);
    }
}
