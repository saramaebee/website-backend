package dev.codesupport.web.api.data.repository;

import dev.codesupport.web.api.data.entity.ShowcaseEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShowcaseRepositoryTest {

    //Unused - Assigned by autowire
    @SuppressWarnings("unused")
    @Autowired
    private ShowcaseRepository showcaseRepository;

    @Test
    public void shouldReturnCorrectShowcasesByUserId() {
        List<ShowcaseEntity> showcaseEntities = showcaseRepository.findAllByUser_IdOrderById(2L);

        List<String> actual = new ArrayList<>();
        for (ShowcaseEntity entity : showcaseEntities) {
            actual.add(entity.toString());
        }

        List<String> expected = Collections.singletonList("ShowcaseEntity(id=1, user=UserEntity(id=2, alias=Lambo, hashPassword=$2a$10$ss9M0jlCsYDEIA0iBnAyi.PK8TJhpv/Y.tpILVOMKXIvmkOov.Eim, discordId=null, discordUsername=LamboCreeper#666, githubUsername=lambocreeper, jobTitle=null, jobCompany=null, email=lam.bo@cs.dev, avatarLink=lambo.jpg, disabled=false, role=RoleEntity(id=1, code=admin, label=admin, permission=[PermissionEntity(id=1, code=write, label=write)]), permission=[], biography=Push my PR!, country=CountryEntity(id=2, code=uk, label=United Kingdom), userAward=[], joinDate=1570406400000), title=Showcase Title, description=Showcase Description, approved=true, link=http://www.example.com/1, contributorList=ContributorListEntity(id=1))");

        assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnCorrectShowcasesByAlias() {
        List<ShowcaseEntity> showcaseEntities = showcaseRepository.findAllByUser_AliasIgnoreCaseOrderById("lambo");

        List<String> actual = new ArrayList<>();
        for (ShowcaseEntity entity : showcaseEntities) {
            actual.add(entity.toString());
        }

        List<String> expected = Collections.singletonList("ShowcaseEntity(id=1, user=UserEntity(id=2, alias=Lambo, hashPassword=$2a$10$ss9M0jlCsYDEIA0iBnAyi.PK8TJhpv/Y.tpILVOMKXIvmkOov.Eim, discordId=null, discordUsername=LamboCreeper#666, githubUsername=lambocreeper, jobTitle=null, jobCompany=null, email=lam.bo@cs.dev, avatarLink=lambo.jpg, disabled=false, role=RoleEntity(id=1, code=admin, label=admin, permission=[PermissionEntity(id=1, code=write, label=write)]), permission=[], biography=Push my PR!, country=CountryEntity(id=2, code=uk, label=United Kingdom), userAward=[], joinDate=1570406400000), title=Showcase Title, description=Showcase Description, approved=true, link=http://www.example.com/1, contributorList=ContributorListEntity(id=1))");

        assertEquals(expected, actual);
    }

}
