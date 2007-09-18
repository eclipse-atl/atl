load_metamodel name='TCS' path='/AMMACore/KM3/TCS/TCS.ecore' modelHandler='EMF'

load_model name='ASL.tcs' metamodel='TCS' path='ASL.tcs'
	injector ebnf
		params {
			param name='name' value='TCS'
		}

load_metamodel name='KM3' nsUri='http://www.eclipse.org/gmt/2005/KM3' modelHandler='EMF'

load_model name='ASL.km3' metamodel='KM3' path='ASL.km3'
	injector ebnf
		params {
			param name='name' value='KM3'
		}

load_metamodel name='Problem' nsUri='http://www.eclipse.org/gmt/2005/Problem' modelHandler='EMF'

load_model name='Problem.tcs' metamodel='TCS' path='/AMMACore/KM3/TCS/Problem/Problem.tcs'
	injector ebnf
		params {
			param name='name' value='TCS'
		}
	
atl path='/AMMACore/KM3/ATL-0.2/TCS2Problem/TCS2Problem.asm'
	inModel name='IN' model='ASL.tcs'
	inModel name='TCS' model='TCS'
	inModel name='MM' model='ASL.km3'
	inModel name='KM3' model='KM3'
	inModel name='Problem' model='Problem'
	outModel name='OUT' model='ASL.pbs' metamodel='Problem'
	library name='KM3Helpers' path='/AMMACore/KM3/ATL-0.2/KM3Helpers/KM3Helpers.asm'
	library name='strings' path='/AMMACore/KM3/ATL-0.2/strings/strings.asm'

save_model model='ASL.pbs' path='ASL.pbs'
	extractor ebnf
		params {
			param name='format' value='Problem.tcs'
			param name='identEsc' value=''
			param name='indentString' value='	'
		}

apply_markers model='ASL.pbs' path='${AM3path}${metamodel}.tcs'