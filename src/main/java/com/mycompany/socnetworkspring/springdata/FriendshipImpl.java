//package com.mycompany.socnetworkspring.springdata;
//
//import com.mycompany.socnetworkspring.percistence.IDAOFriendship;
//import com.mycompany.socnetworkspring.percistence.enteties.Friendship;
//import com.mycompany.socnetworkspring.percistence.enteties.User;
//import com.mycompany.socnetworkspring.percistence.repositories.FriendshipRepository;
//import lombok.AllArgsConstructor;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//@AllArgsConstructor
//public class FriendshipImpl implements IDAOFriendship {
//    private FriendshipRepository friendshipRepository;
//    @Override
//    public Friendship create(Friendship obj) {
//        return friendshipRepository.save(obj);
//    }
//
//    @Override
//    public Friendship update(Friendship obj) {
//        return friendshipRepository.save(obj);
//    }
//
//    @Override
//    public void delete(Long id) {
//        friendshipRepository.deleteById(id);
//    }
//
//    @Override
//    public List<Friendship> findAll() {
//        return friendshipRepository.findAll();
//    }
//
//    @Override
//    public Optional<Friendship> findById(Long id) {
//        return friendshipRepository.findById(id);
//    }
//
//    @Override
//    public Optional<Friendship> findByUserId1AndUserId2(Long userId1, Long userId2) {
//        return Optional.empty();
//    }
//
//    @Override
//    public List<Friendship> findByUserId1(Long userId) {
//        return friendshipRepository.findByUserId1(userId);
//    }
//
//    @Override
//    public long countByUserId1(Long userId) {
//        return 0;
//    }
//}
