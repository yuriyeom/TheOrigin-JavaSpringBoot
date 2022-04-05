# Spring_Boot_Mission

## 2차 미션 스크린샷
### Basic
<details>
<summary>펼쳐보기</summary>
<div markdown="1">

- **Board Create**  
![BoardCreate](https://user-images.githubusercontent.com/43941336/155078940-538580d4-33f8-4760-b98e-aa1b51390fbb.png)   
   
- **Board Read All**  
![BoardReadAll](https://user-images.githubusercontent.com/43941336/155078972-eaca7247-a913-4995-bbc8-663304072559.png)   
   
- **Board Read One**  
![BoardReadOne](https://user-images.githubusercontent.com/43941336/155078996-d21d6264-e92e-4bf8-b244-2c533540c45a.png)   
   
- **Board Update**  
![BoardUpdate](https://user-images.githubusercontent.com/43941336/155079009-6dc32866-464b-4750-8418-15fad266771a.png)   
   
  Update 후 Read   
![BoardUpdate2](https://user-images.githubusercontent.com/43941336/155079030-22df27b3-37b9-4c6a-b72a-f9aa9fca79c0.png)    
- **Board Delete**   
![BoardDelete](https://user-images.githubusercontent.com/43941336/155079059-d56111e7-5cf2-439f-aab4-38d06102006d.png)   
   
  Delete 후 Read   
  ![BoardDelete2](https://user-images.githubusercontent.com/43941336/155079089-0df4a05c-6219-406a-8484-5da051802af0.png)   
- **Post Create**  
![PostCreate](https://user-images.githubusercontent.com/43941336/155077141-0e4c0feb-5c02-4c8c-8b4d-30bc372c4445.png)       
- **Post Read All**   
![PostReadAll](https://user-images.githubusercontent.com/43941336/155077220-bea3bbb1-d7a2-45c1-a1d5-8845cd58b0bf.png)   
- **Post Read By Board**   
![PostReadByBoard](https://user-images.githubusercontent.com/43941336/155077167-3038a919-d355-4a61-9b17-f54acafe38e0.png) 
- **Post Read One**  
![PostReadOne](https://user-images.githubusercontent.com/43941336/155077253-4170c13a-0427-4aef-86e4-be2be967747c.png)   
- **Post Update**  
![PostUpdate](https://user-images.githubusercontent.com/43941336/155077292-7fbd78a1-131c-4c46-b5be-69b9bb90454b.png)   
Update 후 Read   
![PostUpdate2](https://user-images.githubusercontent.com/43941336/155077335-1070aadb-eb3e-45f1-b4ff-d27c2e3dde8e.png)   
- **Post Delete**   
![PostDelete](https://user-images.githubusercontent.com/43941336/155077362-2c0b2143-54d5-4caa-a1f2-3b4883c24d38.png)   
  Delete 후 Read   
![PostDelete2](https://user-images.githubusercontent.com/43941336/155077384-60a76b8f-9acf-47b1-a96f-fccae8f0a9e5.png)   

</div>
</details>
   

## 3차 미션 스크린샷
### Basic
<details>
<summary>펼쳐보기</summary>
<div markdown="1">
- **PostEntity와 BoardEntity 관계** 
   - PostEntity  
![PostEntity](https://user-images.githubusercontent.com/43941336/157228904-cdbb9fe1-86ce-497e-8fbe-41a3361dbdda.png)   
   - BoardEntity  
![BoardEntity](https://user-images.githubusercontent.com/43941336/157228918-8cf68738-212e-4333-8377-99afd4478e1a.png)   
   - ManyToOne 양방향 관계   
      - in PostEntity     
![PostManyToOne](https://user-images.githubusercontent.com/43941336/157228956-c5350ece-05be-4f57-a83e-df64e5e5bca0.png)   
      - in BoardEntity     
![BoardOneToMany](https://user-images.githubusercontent.com/43941336/157228966-53731838-efc4-4307-8a3e-59431cca0516.png)   
      Post와 Board는 다대일 관계이므로 @ManyToOne 양방향 관계를 맺어줬다.   
      boardEntity는 board_id라는 이름의 외래 키로 매핑된다.   
- **UserEntity와 PostEntity 관계**  
   - UserEntity  
![UserEntity](https://user-images.githubusercontent.com/43941336/157229522-c7f74bc1-8589-42dd-ac61-39b192d53d9d.png)    
   - ManyToOne 양방향 관계   
      - in PostEntity     
![PostUserEntity](https://user-images.githubusercontent.com/43941336/157229559-7f8a714f-ee53-4643-b422-740754c6800d.png)    
      - in UserEntity     
![UserPostEntityList](https://user-images.githubusercontent.com/43941336/157229602-c635c342-79f3-4304-9d75-a155ced27682.png)   
      Post와 User는 다대일 관계이므로 @ManyToOne 양방향 관계를 맺어줬다.    
      userEntity는 user_id라는 이름의 외래 키로 매핑된다.   
- **UserEntity CRUD**
   - **User Create**  
![UserCreate](https://user-images.githubusercontent.com/43941336/157230187-4ebcbc67-c610-48f2-90c6-8724ee104fe0.png)       
   - **User Read All**   
![UserReadAll](https://user-images.githubusercontent.com/43941336/157230197-659459af-c566-4eff-8f20-032da6b85869.png)   
   - **User Read One**  
![UserRead](https://user-images.githubusercontent.com/43941336/157230203-82d6fa22-1d58-48e3-930c-f5c88c568b8b.png)   
   - **User Update**  
![UserUpdate](https://user-images.githubusercontent.com/43941336/157230215-50c3f46f-eee0-48c9-91b9-06b5f5010ec0.png)   
   Update 후 Read   
![UserUpdate2](https://user-images.githubusercontent.com/43941336/157230216-73750dba-673e-4d89-8d50-d244cee8f1c3.png)   
   - **User Delete**   
![UserDelete](https://user-images.githubusercontent.com/43941336/157230234-101814e4-3ce2-44fe-b58e-67709dd27041.png)   
   Delete 후 Read   
![UserDelete2](https://user-images.githubusercontent.com/43941336/157230236-cd456321-4d33-4762-adad-da6eba3f1feb.png)   
- **Post 작성할 때 User의 정보를 어떻게 전달하는가**    
   `{
    "title": "First Post in board1!",
    "content" : "CRUD is hard.",
    "writer": "glassym"
   }`   
   
   Post를 작성할 때 위와 같은 JSON 데이터로 입력받는데 User는 writer라는 이름의 문자열로 받는다.

   PostDto에서는 User의 정보를 name으로만 저장하고 PostEntity에서는 UserEntity로 저장한다.

   PostDao에서 PostDto를 PostEntity로 변환할 때는 

   `UserEntity userEntity = this.userDao.readUserByWriter(dto.getWriter());`

   writer 값으로 UserEntity를 찾는 함수를 사용해서 UserEntity를 넣어준다.
- **개발환경 / 상용환경 분리**  
   상용환경에서 spring.jpa.hibernate.ddl-auto : update 설정을 통해 데이터가 유지되도록 했다.   
   - yml 파일 구성   
![ymlFiles](https://user-images.githubusercontent.com/43941336/157230610-67437f27-3f83-4f8d-9e2a-2066203a9ed3.png)   
   - dev : 개발 환경, H2 사용   
![application-dev](https://user-images.githubusercontent.com/43941336/157230626-607a0935-2d17-41be-824d-b65413f97984.png)   
   - prod : 상용 환경, MySQL 사용   
![application-prod](https://user-images.githubusercontent.com/43941336/157230630-712ba7aa-0f44-4812-8a43-ef029c00df7a.png)   


### Challenge
필드 부분만 캡쳐했습니다.

- **AreaEntity**  
![AreaEntity](https://user-images.githubusercontent.com/43941336/157253015-490a511e-d7c8-4dd4-a844-a95add74523b.PNG)   

- **UserEntity**  
![UserEntity](https://user-images.githubusercontent.com/43941336/157253074-06d1e154-627d-4080-a9c0-10499569409e.PNG)   
User 분류로 일반 사용자, 상점 주인 중 하나의 값을 가질 수 있도록 enum을 사용했다.   
   - enum Auth   
   ![enumAuth](https://user-images.githubusercontent.com/43941336/157253427-ae719f34-aed1-477f-ae8a-a3d3dea9384d.PNG)   
- **ShopEntity**   
![ShopEntity](https://user-images.githubusercontent.com/43941336/157253103-d42653d5-5d53-43b3-9887-c90afde87da1.PNG)   
취급 품목 카테고리로 미리 정의된 값들 중 하나를 가질 수 있도록 enum을 사용했다.
현재는 임의값으로 설정해두었다.
   - enum Category   
   ![enumCategory](https://user-images.githubusercontent.com/43941336/157253422-75aa9693-a696-4704-9b10-05254f1507ea.PNG)   

- **ShopPostEntity**    
![ShopPostEntity](https://user-images.githubusercontent.com/43941336/157253133-53df0c4f-a23c-4318-803e-c4d1ad523a69.PNG)       
해당 ShopEntity의 주인 UserEntity만 작성할 수 있는 기능은 ShopPostEntity에 있는 userEntity와 shopEntity가 가지고 있는 user를 비교하면 된다.

- **ShopReviewEntity**     
![ShopReviewEntity](https://user-images.githubusercontent.com/43941336/157253159-dc58b3db-a709-4380-905a-1f016033d2fd.PNG)   

- **생성된 테이블**   
![table](https://user-images.githubusercontent.com/43941336/157253241-e2cf58b7-b0f6-4af0-a38b-b0bbb634b7b9.PNG)       

- **새로운 엔티티간 연관관계**   
   UserEntity - AreaEntity : 다대일 양방향   
   
   ShopEntity - AreaEntity : 다대일 양방향   
   ShopEntity - UserEntity : 다대일 양방향 // 상점 주인일 경우   
   
   ShopPostEntity - ShopEntity : 다대일 양방향   
   ShopPostEntity - UserEntity : 다대일 단방향 // 상점 주인일 경우   
   
   ShopReviewEntity - ShopEntity : 다대일 양방향   
   ShopReviewEntity - UserEntity : 다대일 단방향   

</div>
</details>

## 4차 미션 스크린샷
### Basic

<details>
<summary>펼쳐보기</summary>
<div markdown="1">   
   
- **UserEntity**      
   ```java
    @Entity
    @Table(name = "community_user")
    public class UserEntity {
       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;

       private String username;
       private String password;

       @ManyToOne(
               targetEntity = AreaEntity.class,
               fetch = FetchType.LAZY
       )
       @JoinColumn(name = "area_id")
       private AreaEntity residence;

       private Boolean isShopOwner;
         
       ...
         
    }
   ```
- **CommunityUserDetailsService**   
   ``` java
    @Service
    public class CommunityUserDetailsService implements UserDetailsService {
       private final UserRepository userRepository;
       private final PasswordEncoder passwordEncoder;

       public CommunityUserDetailsService(
               @Autowired UserRepository userRepository
       ){
           this.userRepository = userRepository;
       }

       @Override
       public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
           Optional<UserEntity> userEntity = this.userRepository.findByUsername(username);
           if(userEntity.isEmpty()){ // 해당하는 사용자가 없을시
               throw new UsernameNotFoundException("username not found");
           }
           // UserEntity를 UserDetails로 반환
           return new User(username, userEntity.get().getPassword(), new ArrayList<>());
       }
    }
   ```   
- **UserEntity**      
   ``` java
   @Controller
   @RequestMapping("user")
   public class UserController {
       private static final Logger logger = LoggerFactory.getLogger(UserController.class);
       private final UserRepository userRepository;
       private final PasswordEncoder passwordEncoder;
       private final AreaRepository areaRepository;

       public UserController(
               @Autowired UserRepository userRepository,
               @Autowired PasswordEncoder passwordEncoder,
               @Autowired AreaRepository areaRepository
       ) {
           this.passwordEncoder = passwordEncoder;
           this.userRepository = userRepository;
           this.areaRepository = areaRepository;
       }

       @GetMapping("login")
       public String login(){
           return "login-form";
       }

       @GetMapping("signup")
       public String signup(){
           return "signup-form";
       }

       @PostMapping("signup")
       public String signupPost(
               @RequestParam("username") String username,
               @RequestParam("password") String password,
               @RequestParam("password_check") String passwordCheck,
               @RequestParam(value = "is_shop_owner", required = false) boolean isShopOwner
       ){
           if(!password.equals(passwordCheck)){ // 비밀번호 확인이 틀릴 시
               throw new ResponseStatusException(HttpStatus.NOT_FOUND);
           }
           UserEntity userEntity = new UserEntity();
           userEntity.setUsername(username);
           userEntity.setPassword(passwordEncoder.encode(password));
           // residence는 미리 생성해둔 3가지 데이터 중 랜덤으로 들어가게 했다. (id: 1~3)
           Optional<AreaEntity> residence = this.areaRepository.findById((long) (Math.random() * 3 + 1));
           userEntity.setResidence(residence.get());
           userEntity.setShopOwner(isShopOwner);
           logger.info("is shop owner : " + isShopOwner);
           this.userRepository.save(userEntity);
           return "redirect:/home";
       }

   ```
- **회원가입 과정**   
   a. 회원가입 form   
   ![image](https://user-images.githubusercontent.com/43941336/159295482-fd6a5195-7405-4ae7-9701-7906f951f20d.png)   
   b. 회원가입 후 isShopOwner 값을 로그로 남겼다.   
   ![image](https://user-images.githubusercontent.com/43941336/159295560-3896d952-afc9-42ab-bce0-6be0fb72ef76.png)   
   c. DB에 추가된 데이터 확인   
   ![image](https://user-images.githubusercontent.com/43941336/159295581-4dcfc0d0-cfe9-4ec5-bf71-fd73e3e944c2.png)   
   d. 로그인 후 홈 화면   
   ![image](https://user-images.githubusercontent.com/43941336/159295606-57e4b10e-f5d3-43a7-a22f-28ea6813f95e.png)   

</div>
</details>   
   
## 5차 미션 스크린샷   
### Basic
- **[index.html] Geolocation API 사용**   
   
   ```html
   <!DOCTYPE html>
   <html
           lang="en"
           xmlns:th="http://www.thymeleaf.org"
           xmlns:sec="http://www.w3.org/1999/xhtml"
   >
   <head>
       <meta charset="UTF-8">
       <title>Simple Home</title>
   </head>
   <body>
       <div sec:authorize="isAnonymous()">
           <h2>Hello World</h2>
           <button onclick="location.href = '/user/login'">로그인</button>
           <button onclick="location.href = '/user/signup'">회원가입</button>

       </div>
       <div sec:authorize="isAuthenticated()">
           <h3 >
               반갑습니다. <span sec:authentication="name"></span>님!
           </h3><br>
          <!-- 버튼 클릭시 getLocation()를 호출한다. -->
           <input type="button" onclick="getLocation()" value="위도/경도 확인"> 
           <form th:action="@{/user/logout}" method="post">
               <input type="submit" th:value="로그아웃">
           </form>
       </div>
   </body>
   <script>
       function getLocation() {
           if (navigator.geolocation) {
               navigator.geolocation.getCurrentPosition(showPosition);
           } else {
               alert("Geolocation is not supported by this browser.");
           }
       }

       function showPosition(position) {
           alert(`Latitude: ${position.coords.latitude}, Longitude: ${position.coords.longitude}`);
       }

       // await fetch(`/area/get-location-info?latitude=${latitude}&longitude=${longitude}`);

   </script>
   </html>
   ```
   
  - 로그인 성공했을 때 화면   
   ![image](https://user-images.githubusercontent.com/43941336/161748874-bbb1bd47-c9b4-40d3-9a4c-b3b417d4acb1.png)   
   - 버튼 클릭시 나타나는 현재 위치의 위도, 경도를 담은 Alert
   ![image](https://user-images.githubusercontent.com/43941336/161749301-0bc7fe30-5063-4b03-a404-fea9184013a9.png)   
   - 위도, 경도를 담은 경로로 HTTP 요청을 보내는 기능은 구현하지 못했습니다.   

- **[AreaController] 위도, 경도 인자를 받는 RequestMapping 메소드**   
   ```java
    @GetMapping("/get-location-info")
    public AreaDto inputLatLong(
            @RequestParam("latitude") Double latitude,
            @RequestParam("longitude") Double longitude
    ){
        return this.areaService.findClosestArea(latitude, longitude);
    }
   ```
- **[AreaService] 위도, 경도 인자로부터 가장 가까운 Area를 찾는 메소드**   
   ```java
    public AreaDto findClosestArea(Double lat, Double lon){
        List<AreaDto> areaDtoList = this.readAreaAll(); // 저장된 모든 Area를 불러온다.
        Double min = 1000.0; // 최단 거리값
        long find = 0; // 가장 가까운 Area의 id
   
        for(AreaDto area : areaDtoList){ // 리스트의 모든 Area를 돌면서 가장 가까운 Area를 찾는다.
            Double tmpLat = area.getLatitude();
            Double tmpLon = area.getLongitude();

            Double value = haversine(lat, lon, tmpLat, tmpLon); // 두 지점 간 거리 계산
            if(min > value){
                min = value;
                find = area.getId();
            }
        }
        // 가장 가까운 Area의 Entity를 찾는다.
        Optional<AreaEntity> target = this.areaRepository.findById(find);
        if(target.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        // 찾은 Entity를 Dto로 변환한다.
        AreaDto areaDto = new AreaDto();
        areaDto.setId(find);
        areaDto.setRegionMajor(target.get().getRegionMajor());
        areaDto.setRegionMinor(target.get().getRegionMinor());
        areaDto.setRegionPatch(target.get().getRegionPatch());
        areaDto.setLatitude(target.get().getLatitude());
        areaDto.setLongitude(target.get().getLongitude());
        logger.info(areaDto.toString());
   
        return areaDto;
    }
   ```
   
   ```java
    // 두 지점의 거리를 위도, 경도로 계산하는 함수
    public static final double R = 6372.8; // In kilometers
    public static double haversine(double lat1, double lon1, double lat2, double lon2) {
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        double a = Math.pow(Math.sin(dLat / 2),2) + Math.pow(Math.sin(dLon / 2),2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.asin(Math.sqrt(a));
        return R * c;
    }

    // This function converts decimal degrees to radians
    private static double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    // This function converts radians to decimal degrees
    private static double rad2deg(double rad) {
        return (rad * 180 / Math.PI);
    }
   ```
- POSTMAN 테스트
   ![image](https://user-images.githubusercontent.com/43941336/161750756-d7606a5b-73dc-48dc-b2af-b1ab7bdbaa10.png)   
   - 요청 URL : http://localhost:8080/area/get-location-info?latitude=37.51148310935&longitude=127.06033711446   
   - 테스트로 넣은 값은 삼성 코엑스입니다. 그 결과 삼성동이 가장 가까운 곳으로 나타났습니다.
   

   
   
