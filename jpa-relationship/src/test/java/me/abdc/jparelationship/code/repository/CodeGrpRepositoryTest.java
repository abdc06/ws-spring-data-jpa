package me.abdc.jparelationship.code.repository;

import me.abdc.jparelationship.code.entity.CodeDtl;
import me.abdc.jparelationship.code.entity.CodeGrp;
import me.abdc.jparelationship.code.entity.CodeMst;
import me.abdc.jparelationship.code.entity.cmkey.CodeDtlId;
import me.abdc.jparelationship.code.entity.cmkey.CodeMstId;
import me.abdc.jparelationship.common.entity.Ids;
import me.abdc.jparelationship.common.service.IdsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class CodeGrpRepositoryTest {

    @Autowired
    IdsService idsService;
    @Autowired
    CodeGrpRepository codeGrpRepository;
    @Autowired
    CodeMstRepository codeMstRepository;
    @Autowired
    CodeDtlRepository codeDtlRepository;

    @Test
    void init() {
        setData();
    }

    void setData() {
        CodeGrp codeGrp = new CodeGrp();
        codeGrp.setCodeGrpId(idsService.getNextId(Ids.CODE_GRP));
        codeGrp.setCodeGrpNm("SYSTEM");
        codeGrp.setCodeGrpDesc("시스템 그룹");
        CodeGrp savedCodeGrp = codeGrpRepository.save(codeGrp);

        IntStream.range(1, 4).forEach(i -> {
            CodeMstId codeMstId = new CodeMstId();
            codeMstId.setCodeMstId(idsService.getNextId(Ids.CODE_MST));

            CodeMst codeMst = new CodeMst();
            codeMst.setCodeMstId(codeMstId);
            codeMst.setCodeMstNm("공통분류코드" + i);
            codeMst.setCodeGrp(savedCodeGrp);
            CodeMst savedCodeMst = codeMstRepository.save(codeMst);

            IntStream.range(1, 4).forEach(j -> {
                CodeDtlId codeDtlId = new CodeDtlId();
                codeDtlId.setCodeDtlId(idsService.getNextId(Ids.CODE_DTL));

                CodeDtl codeDtl = new CodeDtl();
                codeDtl.setCodeDtlId(codeDtlId);
                codeDtl.setCodeVal("0" + String.valueOf(j));
                codeDtl.setCodeNm(j == 1 ? "A" : j == 2 ? "B" : "C");
                codeDtl.setCodeMst(savedCodeMst);
                codeDtlRepository.save(codeDtl);
            });
        });
    }
}