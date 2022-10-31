package me.abdc.jparelation.board.repository;

import me.abdc.jparelation.board.entity.Board;
import me.abdc.jparelation.board.entity.Comment;
import me.abdc.jparelation.board.entity.Post;
import me.abdc.jparelation.common.entity.Ids;
import me.abdc.jparelation.common.entity.Member;
import me.abdc.jparelation.common.repository.MemberRepository;
import me.abdc.jparelation.common.service.IdsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BoardRepositoryTest {

    @Autowired
    IdsService idsService;
    @Autowired
    BoardRepository boardRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    MemberRepository memberRepository;
    @Test
    void create() {
        init();

        List<Board> boards = boardRepository.findAll();
        List<Post> posts = postRepository.findAll();
        List<Comment> comments = commentRepository.findAll();

        assertThat(boards.size()).isEqualTo(1);
        assertThat(posts.size()).isEqualTo(4);
        assertThat(comments.size()).isEqualTo(12);
    }

    void init() {
        Member member = new Member();
        member.setMemberId("kim123");
        member.setMemberNm("김태호");
        member.setEmail("abdc2806@gmail.com");
        member.setPhone("01012345678");
        Member savedMember = memberRepository.save(member);

        Board board = new Board();
        board.setBoardId(idsService.getNextId(Ids.BOARD));
        board.setBoardNm("Notice");
        Board savedBoard = boardRepository.save(board);

        IntStream.range(1, 5).forEach(i -> {
            Post post = new Post();
            post.setPostId(idsService.getNextId(Ids.POST));
            post.setTitle("hibernate" + i);
            post.setBoard(savedBoard);
            post.setOwner(savedMember);
            Post savedPost = postRepository.save(post);

            IntStream.range(1, 4).forEach(j -> {
                Comment comment = new Comment();
                comment.setCommentId(idsService.getNextId(Ids.COMMENT));
                comment.setComment("comment/" + i + "/" + j);
                comment.setPost(savedPost);
                comment.setOwner(savedMember);
                commentRepository.save(comment);
            });
        });
    }

}