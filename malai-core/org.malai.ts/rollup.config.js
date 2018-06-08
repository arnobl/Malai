import resolve from 'rollup-plugin-node-resolve';
import commonjs from 'rollup-plugin-commonjs';
import typescript from 'rollup-plugin-typescript2';
import includePaths from 'rollup-plugin-includepaths';
import pkg from './package.json'

let includePathOptions = {
  include: {},
    paths : ['src/*'],
    external: [],
    extensions: ['.ts', '.js']
};

export default {
    input: pkg.main,
    output: {
        name: 'WidgetBinder',
        file : 'lib/WidgetBinder.js',
        format: 'umd'
    },
    plugins: [
        resolve(),
        commonjs(),
        typescript(),
        includePaths(includePathOptions)
],
};