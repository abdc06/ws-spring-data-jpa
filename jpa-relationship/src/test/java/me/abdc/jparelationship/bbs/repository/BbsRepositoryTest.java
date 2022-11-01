package me.abdc.jparelationship.bbs.repository;

import me.abdc.jparelationship.bbs.entity.Bbs;
import me.abdc.jparelationship.bbs.entity.Ntt;
import me.abdc.jparelationship.bbs.entity.Reply;
import me.abdc.jparelationship.common.entity.Ids;
import me.abdc.jparelationship.common.service.IdsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BbsRepositoryTest {

    @Autowired
    IdsService idsService;
    @Autowired
    BbsRepository bbsRepository;
    @Autowired
    NttRepository nttRepository;
    @Autowired
    ReplyRepository replyRepository;

    @Test
    void init() {
        setData();

        List<Bbs> boards = bbsRepository.findAll();
        List<Ntt> posts = nttRepository.findAll();
        List<Reply> comments = replyRepository.findAll();

        assertThat(boards.size()).isEqualTo(1);
        assertThat(posts.size()).isEqualTo(4);
        assertThat(comments.size()).isEqualTo(12);
    }

    void setData() {
        Bbs bbs = new Bbs();
        bbs.setBbsId(idsService.getNextId(Ids.BBS));
        bbs.setBbsNm("Notice");
        Bbs savedBbs = bbsRepository.save(bbs);

        IntStream.range(1, 5).forEach(i -> {
            Ntt ntt = new Ntt();
            ntt.setNttId(idsService.getNextId(Ids.NTT));
            ntt.setTitle("hibernate" + i);
            ntt.setBbs(savedBbs);
            Ntt savedNtt = nttRepository.save(ntt);

            IntStream.range(1, 4).forEach(j -> {
                Reply reply = new Reply();
                reply.setReplyId(idsService.getNextId(Ids.REPLY));
                reply.setContent("reply/" + i + "/" + j);
                reply.setNtt(savedNtt);
                replyRepository.save(reply);
            });
        });
    }

}