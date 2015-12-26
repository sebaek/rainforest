package com.rainforest.site;

import java.util.Map;
import java.util.Set;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rainforest.entities.User;

@Controller("/") 
public class BaseController {
	
	@Inject
	BaseService baseService;

	@RequestMapping(value="hello", method=RequestMethod.GET)
	public String hello() {
		return "hello";
	}
	
	private int seq;
	
	public int getSeq() {
		return ++this.seq;
	}
	
	@RequestMapping(value="match", method=RequestMethod.POST) 
	public @ResponseBody String match(@ModelAttribute User user)  {
//	public @ResponseBody User match(@ModelAttribute User user)  {
		
		System.out.println(user);
		
		// 맵에 담음
//		int seq = UserRepository.getSeq() + 2;
//		UserRepository.setSeq(seq);
//		UserRepository.getUserMap().put(seq, user);
		
		// 맵에 유저정보 담음
		int seq = getSeq();
		user.setSeq(seq);
		UserRepository.getUserMap().put(seq, user);
		System.out.println(UserRepository.getUserMap().toString());
		
		// 상대를 찾음
		int count = 0;
		while ( !isMatch(user) ) {
			System.out.println((++count) + " : " + user.toString());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		// 상대정보 문자열로 저장
		String returnStr = UserRepository.getUserMap().get(user.getMatchedSeq()).toString();
		System.out.println("pare : " + user.getSeq() + " - " + user.getMatchedSeq());
		
		// 맵에서 유저정보 삭제; 본인은 본인 thread에서 삭제; -- 수정
		Map<Integer, User> userMap = UserRepository.getUserMap();
		// 상대가 thread에서 나갔는지 확인 후 본인, 상대 정보를 맵에서 삭제
		if (userMap.get(user.getMatchedSeq()).isOut()) {
			userMap.remove(user.getSeq());
			userMap.remove(user.getMatchedSeq());
			System.out.println(" delete : " + user.getSeq());
			System.out.println(" delete : " + user.getMatchedSeq());
		}
		// thread 에서 나감표시 할당
		user.setOut(true);
		
		return returnStr;
//		return user;
		
/*			
		try {
			if (!UserRepository.users.isEmpty()) {
				User u = UserRepository.users.iterator().next();
				UserRepository.users.clear();
				return " 당신의 대화 상대는 " + u.getNickName() + " 입니다.";
			} else {
				UserRepository.users.add(user);
			}
			
			while (true) {
				Thread.sleep(1000);
			}
			
			
		} catch (InterruptedException e) {
			System.out.println(user.getNickName() + " was interrupted.");
			e.printStackTrace();
		}
		return "matched";
 */			
	}
	
	/**
	 * @param map index
	 * @return
	 */
	public boolean isMatch(User user) {
		
		// 짝 찾은 상태인지 확인 후 반환 true
		if (user.isMatched()) {
			return true;
		}
		
		// 리스트를 돌면서 이성을 찾음
		// FIXME: 미리 복사해놔야함.
		Map<Integer, User> userMap = UserRepository.getUserMap();
		
		// 찾으면 서로의 시퀀스를 짝으로 할당
		Set<Integer> keySet = userMap.keySet();
		System.out.println("remain user : " + keySet.size() + keySet.toString());
		
		for (Integer seq : keySet) {
			User targetUser = userMap.get(seq);
//			if (!user.getGender().equals(targetUser.getGender())) {
			if (!targetUser.isMatched() && !user.getGender().equals(targetUser.getGender())) {
				
				user.setMatchedSeq(seq);
				targetUser.setMatchedSeq(user.getSeq());
//				targetUser.setMatchedSeq(seq);
				
				user.setMatched(true);
				targetUser.setMatched(true);
				
				return true;
				
			}
		}
		
		// 못 찾았으면 false 반환
		return false;
	}
	

}
