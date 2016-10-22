module.exports = function (grunt) {
    //Checks how many time each task took
    require('time-grunt')(grunt);

    //Automatically loads every grunt task
    require('load-grunt-tasks')(grunt);

    grunt.initConfig({

            pkg: grunt.file.readJSON('package.json'),

            env: {
                dev: {
                    NODE_ENV: 'DEVELOPMENT'
                },
                deploy: {
                    NODE_ENV: 'DEPLOY'
                }
            },

            clean: {
                all: {
                    options: {force: true},
                    src: ["public/", "deploy/"]
                },
                scss: {
                    options: {force: true},
                    src: ["public/css/*.scss", "deploy/css/*.scss"]
                },
                inc: {
                    options: {force: true},
                    src: ["public/inc", "deploy/inc"]
                }
            },

            copy: {
                dev: {
                    files: [
                        {
                            expand: true, cwd: 'node_modules', src: [
                            'angular/angular.js',
                            'angular-route/**',
                            'angular-resource/**',
                            'ngstorage/**',
                            'jquery/**',
                            'bootstrap/**',
                            'angular-cookies/**'
                        ], dest: 'public/components'
                        },
                        {expand: true, cwd: 'src/modules', src: ['**'], dest: 'public/modules'},
                        {expand: true, cwd: 'src/images', src: ['**'], dest: 'public/images'},
                        {expand: true, cwd: 'src/', src: ['index.html'], dest: 'public/', filter: 'isFile'},
                        {expand: true, cwd: 'src/', src: ['app.js'], dest: 'public/', filter: 'isFile'},
                        {expand: true, cwd: 'src/inc', src: ['**'], dest: 'public/inc'}
                    ]
                },
            },

            sass: {
                dev: {
                    options: {
                        style: 'expanded',
                        compass: true
                    },
                    files: {
                        'public/css/styles.css': 'src/css/styles.scss'
                    }
                }
            },

            preprocess: {
                dev: {
                    src: ['public/**/*.html', 'public/scripts/application.js'],
                    options: {
                        inline: true
                    }
                }
            },

            // Watches files for changes and runs tasks based on the changed files
            watch: {
                files: ['**/*'],
                tasks: ['devTasks'],
                options: {spawn: false}
            }
        }
    );

    //Prepare dev tasks
    grunt.registerTask('devTasks', [
        'env:dev',
        'clean:all',
        'copy:dev',
        'sass:dev',
        'preprocess:dev',
        'clean:inc'
    ]);


    //Run watch tasks
    grunt.registerTask('watcher', 'Run watch tasks', function (project) {
        grunt.task.run([
            'devTasks',
            'watch'
        ]);
    });

    //Run dev tasks
    grunt.registerTask('dev', 'Run dev tasks', function (project) {
        grunt.task.run([
            'devTasks'
        ]);
    });

    //Run default tasks
    grunt.registerTask('default', 'Run default dev tasks', function () {
        grunt.task.run(['devTasks']);
    });

};
