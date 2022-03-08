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


