package competeTest.week.week3_20;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class AuthenticationManager {
	public static void main(String[] args) {
		AuthenticationManager authenticationManager = new AuthenticationManager(5); // 构造 AuthenticationManager ，设置 timeToLive = 5 秒。
		authenticationManager.renew("aaa", 1); // 时刻 1 时，没有验证码的 tokenId 为 "aaa" ，没有验证码被更新。
		authenticationManager.generate("aaa", 2); // 时刻 2 时，生成一个 tokenId 为 "aaa" 的新验证码。
		System.out.println(authenticationManager.countUnexpiredTokens(6));
		authenticationManager.generate("bbb", 7); // 时刻 7 时，生成一个 tokenId 为 "bbb" 的新验证码。
		authenticationManager.renew("aaa", 8); // tokenId 为 "aaa" 的验证码在时刻 7 过期，且 8 >= 7 ，所以时刻 8 的renew 操作被忽略，没有验证码被更新。
		authenticationManager.renew("bbb", 10); // tokenId 为 "bbb" 的验证码在时刻 10 没有过期，所以 renew 操作会执行，该 token 将在时刻 15 过期。
		System.out.println(authenticationManager.countUnexpiredTokens(15));
	}
	Map<String , Integer> map= new HashMap<>();
	Integer liveTime ;
	public AuthenticationManager(int timeToLive) {
		liveTime=timeToLive;
	}

	public void generate(String tokenId, int currentTime) {
		map.put(tokenId,currentTime);
	}

	public void renew(String tokenId, int currentTime) {
		if(!map.containsKey(tokenId)) return;
		map.put(tokenId,currentTime);
	}

	public int countUnexpiredTokens(int currentTime) {
		AtomicInteger res= new AtomicInteger();
		map.forEach((key,value)->{
			if(value<currentTime&&value+liveTime>currentTime){
				res.getAndIncrement();
			}
		});
		return res.get();
	}
}
