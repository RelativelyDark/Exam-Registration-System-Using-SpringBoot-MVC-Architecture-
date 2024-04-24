@CrossOrigin(origins = "http://localhost:4201")
@RestController
@RequestMapping("/api/v2/")
public class FacadeUserController {

    @Autowired
    private UserRepo repo;

    @Autowired
    private UserController userController;

    @Autowired
    private CourseController courseController;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User userData) {
        return userController.loginUser(userData);
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody User userData) {
        return userController.registerUser(userData);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getUser(@PathVariable Long id) {
        return userController.getUser(id);
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody User userData) {
        return userController.updateUser(id, userData);
    }

    @GetMapping("/courses")
    public List<Course> getAllCourses() {
        return courseController.getAllCourses();
    }

    @PostMapping("/courses")
    public Long createCourse(@RequestBody Course course) {
        return courseController.createCourse(course);
    }

    @GetMapping("/courses/{id}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long id) {
        return courseController.getCourseById(id);
    }

    @PutMapping("/courses/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course course) {
        return courseController.updateCourse(id, course);
    }

    @DeleteMapping("/courses/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteCourse(@PathVariable Long id) {
        return courseController.deleteCourse(id);
    }

    @PostMapping("/courses/send")
    public Long listCourses(@RequestBody List<Question> questions) {
        return courseController.listCourses(questions);
    }

}
