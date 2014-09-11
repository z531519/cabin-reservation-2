module.exports = function(grunt) {

    // Project configuration.
    grunt.initConfig({
        pkg: grunt.file.readJSON('package.json'),
        uglify: {
            options: {
                banner: '/*! <%= pkg.name %> <%= grunt.template.today("yyyy-mm-dd") %> */\n'
            },
            build: {
                src: 'src/main/js/*.js',
                dest: 'build/<%= pkg.name %>.min.js'
            }
        },
        wiredep: {

            target: {

                // Point to the files that should be updated when
                // you run `grunt wiredep`
                src: [
                    'src/main/webapp/WEB-INF/jsp/**/*.jsp'

                ],

                // Optional:
                // ---------
                options: {
                    cwd: '',
                    dependencies: true,
                    devDependencies: false,
                    exclude: [],
                    fileTypes: {},
                    ignorePath: '../..',
                    overrides: {}
                }
            }
        }
//        ,
//        karma: {
//            unit: {
//                configFile: 'karma.conf.js'
//            }
//        }
    });

    grunt.loadNpmTasks('grunt-wiredep');

//    // Load the plugin that provides the "uglify" task.
//    grunt.loadNpmTasks('grunt-contrib-uglify');
//
//    // Default task(s).
//    grunt.registerTask('default', ['uglify']);
//
//    grunt.loadNpmTasks('grunt-karma');
//    grunt.registerTask('default', ['karma']);

};