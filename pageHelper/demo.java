public static void main(String[] args) {

    PageEntity<User> pageEntity = new PageEntity<User>();
    PageUtils<User> pageUtils = new PageUtils<User>();
    List<User> userList = new ArrayList<>();
    pageEntity = pageUtils.paging(pageIndex, pageCapacity, userList);

}
